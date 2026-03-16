package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.ItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
import org.example.komplexjavautveckling.items.enums.ItemStatus;
import org.example.komplexjavautveckling.items.enums.ItemType;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ItemDTO> getForgeItems() {
        return repository.findByStatus(ItemStatus.FORGE)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<ItemDTO> getShopItems() {
        return repository.findByStatus(ItemStatus.SHOP)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Item getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Föremålet hittades inte"));
    }

    public List<ItemDTO> search(ItemType type) {

        return repository.findAll()
                .stream()
                .filter(item -> type == null || item.getType() == type)
                .map(mapper::toDTO)
                .toList();
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    private int calculatePrice(int damage) {
        return damage * 2;
    }
}
