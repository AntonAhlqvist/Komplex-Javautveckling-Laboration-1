package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.items.enums.ItemType;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ItemRepository extends ListCrudRepository<Item, Long> {

    List<Item> findByType(ItemType type);

    List<Item> findByNameContainingIgnoreCase(String name);
}
