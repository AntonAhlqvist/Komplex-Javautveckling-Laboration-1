package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.ItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
import org.example.komplexjavautveckling.items.enums.ItemType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ItemMapperTest {

    @Test
    void toEntityCopiesFieldsFromCreateItemDTO() {
        ItemMapper mapper = new ItemMapper();

        CreateItemDTO dto = new CreateItemDTO();
        dto.setName("Anksvärd");
        dto.setType(ItemType.SWORD);
        dto.setDamage(9);
        dto.setWeight(5.7);

        Item item = mapper.toEntity(dto);

        assertEquals("Anksvärd", item.getName());
        assertEquals(ItemType.SWORD, item.getType());
        assertEquals(9, item.getDamage());
        assertEquals(5.7, item.getWeight());
        assertNotNull(item.getCreatedDate());
    }

    @Test
    void updateEntityUpdatesItem() {
        ItemMapper mapper = new ItemMapper();

        Item item = new Item();
        item.setName("Ganska dålig pilbåge");
        item.setType(ItemType.BOW);
        item.setDamage(3);
        item.setWeight(1.5);

        UpdateItemDTO dto = new UpdateItemDTO();
        dto.setName("Bättre pilbåge");
        dto.setType(ItemType.BOW);
        dto.setDamage(7);
        dto.setWeight(2.0);

        mapper.updateEntity(item, dto);

        assertEquals("Bättre pilbåge", item.getName());
        assertEquals(7, item.getDamage());
        assertEquals(2.0, item.getWeight());
    }

    @Test
    void toDTOCopiesFieldsFromItem() {
        ItemMapper mapper = new ItemMapper();

        Item item = new Item();
        item.setName("Silverdolk");
        item.setType(ItemType.DAGGER);
        item.setDamage(6);
        item.setWeight(1.2);
        item.setPrice(12);

        ItemDTO dto = mapper.toDTO(item);

        assertEquals("Silverdolk", dto.getName());
        assertEquals(ItemType.DAGGER, dto.getType());
        assertEquals(6, dto.getDamage());
        assertEquals(1.2, dto.getWeight());
        assertEquals(12, dto.getPrice());
    }
}
