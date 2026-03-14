package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.ItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for managing items in the application.
 * <p>
 * This class contains the business logic for creating, updating,
 * retrieving, and deleting items.
 * <p>
 * Item creation follows the forge mechanic:
 * - Items are created from DTOs via the mapper.
 * - The price is calculated in the service layer based on damage.
 * - The entity is then persisted using the repository.
 * <p>
 * The service ensures separation of concerns by:
 * - Keeping business rules in this layer
 * - Delegating data conversion to the mapper
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

        Item item = mapper.toEntity(dto);

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

    public List<ItemDTO> getAllItems() {
        return repository.findAll()
                .stream()
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
