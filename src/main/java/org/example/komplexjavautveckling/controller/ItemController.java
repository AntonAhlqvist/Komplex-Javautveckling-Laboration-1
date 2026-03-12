package org.example.komplexjavautveckling.controller;

import org.example.komplexjavautveckling.dto.CreateItemDTO;
import org.example.komplexjavautveckling.dto.ItemDTO;
import org.example.komplexjavautveckling.service.ItemService;
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
