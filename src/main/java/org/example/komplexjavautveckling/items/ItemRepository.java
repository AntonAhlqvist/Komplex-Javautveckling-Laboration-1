package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.items.enums.ItemStatus;
import org.example.komplexjavautveckling.items.enums.ItemType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findByStatus(ItemStatus status, Pageable pageable);

    Page<Item> findByStatusAndType(ItemStatus status, ItemType type, Pageable pageable);

    List<Item> findByStatusAndCreatedByUser(ItemStatus status, boolean createdByUser);

    Page<Item> findByCreatedByUser(boolean createdByUser, Pageable pageable);
}
