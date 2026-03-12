package org.example.komplexjavautveckling.items;

import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item toEntity(CreateItemDTO dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setType(dto.getType());
        return item;
    }

    public void updateEntity(Item item, UpdateItemDTO dto) {
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setType(dto.getType());
    }

    public ItemDTO toDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setPrice(item.getPrice());
        dto.setType(item.getType());
        dto.setCreatedDate(item.getCreatedDate());
        return dto;
    }
}
