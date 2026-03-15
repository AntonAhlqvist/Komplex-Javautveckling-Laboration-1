package org.example.komplexjavautveckling.items;

import jakarta.validation.Valid;
import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
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

    @GetMapping("/new")
    public String showCreateForm(Model model) {

        model.addAttribute("createItemDTO", new CreateItemDTO());

        model.addAttribute("items", service.getForgeItems());

        model.addAttribute("weaponTypes", List.of(
                ItemType.SWORD,
                ItemType.DAGGER,
                ItemType.STAFF,
                ItemType.BOW
        ));

        return "items/create";
    }

    @PostMapping("/new")
    public String createItem(@Valid @ModelAttribute("createItemDTO") CreateItemDTO dto,
                             BindingResult result,
                             Model model) {

        if (result.hasErrors()) {

            model.addAttribute("items", service.getForgeItems());

            model.addAttribute("weaponTypes", List.of(
                    ItemType.SWORD,
                    ItemType.DAGGER,
                    ItemType.STAFF,
                    ItemType.BOW
            ));

            return "items/create";
        }

        service.createItem(dto);

        return "redirect:/items/new";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {

        service.deleteItem(id);

        return "redirect:/items/new";
    }

    @GetMapping
    public String listItems(Model model) {

        model.addAttribute("shopItems", service.getShopItems());
        model.addAttribute("forgeItems", service.getForgeItems());

        return "items/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        Item item = service.getEntityById(id);

        model.addAttribute("updateItemDTO", item);
        model.addAttribute("itemId", id);

        model.addAttribute("weaponTypes", List.of(
                ItemType.SWORD,
                ItemType.DAGGER,
                ItemType.STAFF,
                ItemType.BOW
        ));

        return "items/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateItem(@PathVariable Long id,
                             @Valid @ModelAttribute UpdateItemDTO dto,
                             BindingResult result,
                             Model model) {

        if (result.hasErrors()) {
            return "items/edit";
        }

        service.updateItem(id, dto);

        return "redirect:/items/new";
    }
}
