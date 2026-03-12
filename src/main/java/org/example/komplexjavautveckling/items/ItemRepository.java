package org.example.komplexjavautveckling.items;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ItemRepository extends ListCrudRepository<Item, Long> {

    List<Item> findByType(String type);

    List<Item> findByNameContainingIgnoreCase(String name);
}
