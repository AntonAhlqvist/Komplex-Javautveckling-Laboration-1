package org.example.komplexjavautveckling.repository;

import org.example.komplexjavautveckling.entity.Item;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ItemRepository extends ListCrudRepository<Item, Long> {

    List<Item> findByType(String type);

    List<Item> findByNameContainingIgnoreCase(String name);
}
