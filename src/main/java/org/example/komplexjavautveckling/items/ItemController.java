package org.example.komplexjavautveckling.items;

import jakarta.validation.Valid;
import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.enums.ItemType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        model.addAttribute("weaponTypes", List.of(
                ItemType.SWORD,
                ItemType.DAGGER,
                ItemType.STAFF,
                ItemType.BOW
        ));

        return "items/create";
    }

    @PostMapping
    public String createItem(@Valid @ModelAttribute("createItemDTO") CreateItemDTO dto,
                             BindingResult result,
                             Model model) {

        if (result.hasErrors()) {

            model.addAttribute("weaponTypes", List.of(
                    ItemType.SWORD,
                    ItemType.DAGGER,
                    ItemType.STAFF,
                    ItemType.BOW
            ));

            return "items/create";
        }

        service.createItem(dto);

        return "redirect:/items";
    }
}
