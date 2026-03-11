package org.example.komplexjavautveckling.service;

import org.example.komplexjavautveckling.dto.CreateItemDTO;
import org.example.komplexjavautveckling.dto.ItemDTO;
import org.example.komplexjavautveckling.entity.Item;
import org.example.komplexjavautveckling.mapper.ItemMapper;
import org.example.komplexjavautveckling.repository.ItemRepository;
import org.springframework.stereotype.Service;

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
        repository.save(item);
        return mapper.toDTO(item);
    }
}
