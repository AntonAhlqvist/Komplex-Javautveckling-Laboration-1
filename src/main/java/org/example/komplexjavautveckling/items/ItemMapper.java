package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.ItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemMapper {

    public Item toEntity(CreateItemDTO dto) {

        Item item = new Item();

        item.setName(dto.getName());
        item.setType(dto.getType());
        item.setDamage(dto.getDamage());
        item.setWeight(dto.getWeight());

        item.setCreatedDate(LocalDate.now());

        return item;
    }

    public void updateEntity(Item item, UpdateItemDTO dto) {

        item.setName(dto.getName());
        item.setType(dto.getType());
        item.setDamage(dto.getDamage());
        item.setWeight(dto.getWeight());
    }

    public ItemDTO toDTO(Item item) {

        ItemDTO dto = new ItemDTO();

        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setType(item.getType());
        dto.setDamage(item.getDamage());
        dto.setWeight(item.getWeight());
        dto.setPrice(item.getPrice());
        dto.setCreatedDate(item.getCreatedDate());

        return dto;
    }
}
