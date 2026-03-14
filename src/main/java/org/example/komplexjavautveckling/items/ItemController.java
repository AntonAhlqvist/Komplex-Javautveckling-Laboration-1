package org.example.komplexjavautveckling.items;

import jakarta.validation.Valid;
import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "items/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("createItemDTO", new CreateItemDTO());
        return "items/create";
    }

    @PostMapping
    public String createItem(@Valid @ModelAttribute("createItemDTO") CreateItemDTO dto,
                             BindingResult result) {

        if (result.hasErrors()) {
            return "items/create";
        }

        service.createItem(dto);

        return "redirect:/items";
    }
}
