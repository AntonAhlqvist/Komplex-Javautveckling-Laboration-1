package org.example.komplexjavautveckling.items;

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
