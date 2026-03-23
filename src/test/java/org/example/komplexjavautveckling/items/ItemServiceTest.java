package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.exceptions.ResourceNotFoundException;
import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.ItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
import org.example.komplexjavautveckling.items.enums.ItemStatus;
import org.example.komplexjavautveckling.items.enums.ItemType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    ItemRepository repository;

    @Test
    void createItemSetsStatusCreatedByUserAndPrice() {
        ItemMapper mapper = new ItemMapper();
        ItemService service = new ItemService(repository, mapper);

        CreateItemDTO dto = new CreateItemDTO();
        dto.setName("Ankdolk");
        dto.setType(ItemType.DAGGER);
        dto.setDamage(6);
        dto.setWeight(1.5);

        when(repository.save(any(Item.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ItemDTO result = service.createItem(dto);

        ArgumentCaptor<Item> captor = ArgumentCaptor.forClass(Item.class);
        verify(repository).save(captor.capture());

        Item savedItem = captor.getValue();

        assertEquals("Ankdolk", savedItem.getName());
        assertEquals(ItemType.DAGGER, savedItem.getType());
        assertEquals(ItemStatus.FORGE, savedItem.getStatus());
        assertTrue(savedItem.isCreatedByUser());
        assertEquals(12, savedItem.getPrice());

        assertEquals("Ankdolk", result.getName());
        assertEquals(12, result.getPrice());
    }

    @Test
    void updateItemUpdatesFieldsAndPrice() {
        ItemMapper mapper = new ItemMapper();
        ItemService service = new ItemService(repository, mapper);

        Item item = new Item();
        item.setName("Trasig björkstav");
        item.setType(ItemType.STAFF);
        item.setDamage(2);
        item.setWeight(1.5);
        item.setPrice(4);

        UpdateItemDTO dto = new UpdateItemDTO();
        dto.setName("Lagad björkstav");
        dto.setType(ItemType.STAFF);
        dto.setDamage(12);
        dto.setWeight(2.0);

        when(repository.findById(1L)).thenReturn(Optional.of(item));
        when(repository.save(any(Item.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ItemDTO result = service.updateItem(1L, dto);

        assertEquals("Lagad björkstav", item.getName());
        assertEquals(12, item.getDamage());
        assertEquals(2.0, item.getWeight());
        assertEquals(24, item.getPrice());

        assertEquals("Lagad björkstav", result.getName());
        assertEquals(24, result.getPrice());
    }

    @Test
    void getEntityByIdThrowsExceptionWhenItemDoesNotExist() {
        ItemMapper mapper = new ItemMapper();
        ItemService service = new ItemService(repository, mapper);

        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.getEntityById(99L));
    }
}
