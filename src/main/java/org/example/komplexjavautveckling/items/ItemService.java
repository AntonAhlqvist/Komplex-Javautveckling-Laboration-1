package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.ItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
import org.example.komplexjavautveckling.items.enums.ItemStatus;
import org.example.komplexjavautveckling.items.enums.ItemType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Service layer for managing items in the application.
 * <p>
 * This class contains the business logic for creating, updating,
 * retrieving, searching, and deleting items.
 * <p>
 * Items are created through the forge and are restricted to
 * allowed weapon types only. Each created item is assigned a
 * status (FORGE or SHOP) to separate user-created items from
 * shop items.
 * <p>
 * The price is calculated in the service layer based on damage.
 * <p>
 * The service ensures separation of concerns by:
 * <p>
 * - Keeping business rules in this layer
 * <p>
 * - Delegating entity mapping to the ItemMapper
 * <p>
 * - Using the repository only for database access
 */
@Service
public class ItemService {

    private final ItemRepository repository;
    private final ItemMapper mapper;

    public ItemService(ItemRepository repository, ItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ItemDTO createItem(CreateItemDTO dto) {

        if (!dto.getType().isForgeWeapon()) {
            throw new IllegalArgumentException("Denna typ kan inte smidas i smedjan");
        }

        Item item = mapper.toEntity(dto);

        item.setStatus(ItemStatus.FORGE);
        item.setCreatedByUser(true);

        int price = calculatePrice(item.getDamage());
        item.setPrice(price);

        repository.save(item);

        return mapper.toDTO(item);
    }

    public ItemDTO updateItem(Long id, UpdateItemDTO dto) {

        Item item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Föremålet hittades inte"));

        mapper.updateEntity(item, dto);

        int price = calculatePrice(item.getDamage());
        item.setPrice(price);

        repository.save(item);

        return mapper.toDTO(item);
    }

    public void shipForgeItemsToShop() {
        var forgeItems = repository.findByStatusAndCreatedByUser(ItemStatus.FORGE, true);

        for (Item item : forgeItems) {
            item.setStatus(ItemStatus.SHOP);
        }

        repository.saveAll(forgeItems);
    }

    public Page<ItemDTO> getForgeItemsPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return repository.findByCreatedByUser(true, pageable)
                .map(mapper::toDTO);
    }

    public Page<ItemDTO> getShopItemsPaged(ItemType type,
                                           int page,
                                           int size,
                                           String sortBy,
                                           String direction) {

        Sort sort = buildSort(sortBy, direction);
        Pageable pageable = PageRequest.of(page, size, sort);

        if (type == null) {
            return repository.findByStatus(ItemStatus.SHOP, pageable)
                    .map(mapper::toDTO);
        }

        return repository.findByStatusAndType(ItemStatus.SHOP, type, pageable)
                .map(mapper::toDTO);
    }

    private Sort buildSort(String sortBy, String direction) {

        if (sortBy == null || sortBy.isBlank()) {
            return Sort.by("type").ascending()
                    .and(Sort.by("price").ascending());
        }

        Sort.Direction dir = "desc".equalsIgnoreCase(direction)
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        return switch (sortBy) {
            case "name" -> Sort.by(dir, "name");
            case "damage" -> Sort.by(dir, "damage");
            case "weight" -> Sort.by(dir, "weight");
            case "price" -> Sort.by(dir, "price");
            case "createdDate" -> Sort.by(dir, "createdDate");
            default -> Sort.by("type").ascending()
                    .and(Sort.by("price").ascending());
        };
    }

    public Item getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Föremålet hittades inte"));
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    private int calculatePrice(int damage) {
        return damage * 2;
    }
}
