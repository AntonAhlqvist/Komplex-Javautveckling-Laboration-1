package org.example.komplexjavautveckling.items;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public ItemDTO createItem(@RequestBody CreateItemDTO dto) {
        return service.createItem(dto);
    }
}
