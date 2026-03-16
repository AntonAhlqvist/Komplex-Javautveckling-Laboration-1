package org.example.komplexjavautveckling.items;

import jakarta.validation.Valid;
import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.ItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
import org.example.komplexjavautveckling.items.enums.ItemStatus;
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

    /**
     * Displays the forge page where the user can create new weapons.
     * Only weapon types that are allowed in the forge are shown in the dropdown.
     * This prevents items such as armor, potions, and jewelry from being selected.
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {

        model.addAttribute("createItemDTO", new CreateItemDTO());
        model.addAttribute("items", service.getForgeItems());

        model.addAttribute("weaponTypes",
                java.util.Arrays.stream(ItemType.values())
                        .filter(ItemType::isForgeWeapon)
                        .toList()
        );

        return "items/create";
    }

    /**
     * Handles the creation of a new item from the forge form.
     * If there are validation errors, the form is shown again with the
     * allowed weapon types and the existing forge items.
     * If the input is valid, the item is saved and the user is redirected
     * back to the forge page.
     */
    @PostMapping("/new")
    public String createItem(
            @Valid @ModelAttribute("createItemDTO") CreateItemDTO dto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute("items", service.getForgeItems());

            model.addAttribute("weaponTypes",
                    java.util.Arrays.stream(ItemType.values())
                            .filter(ItemType::isForgeWeapon)
                            .toList()
            );

            return "items/create";
        }

        service.createItem(dto);

        return "redirect:/items/new";
    }

    /**
     * Displays the edit page for an existing item.
     * The form is filled with the current item data.
     * Only allowed forge weapon types are shown in the dropdown.
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        var item = service.getEntityById(id);

        UpdateItemDTO dto = new UpdateItemDTO();
        dto.setName(item.getName());
        dto.setType(item.getType());
        dto.setDamage(item.getDamage());
        dto.setWeight(item.getWeight());

        model.addAttribute("updateItemDTO", dto);
        model.addAttribute("itemId", id);
        model.addAttribute("weaponTypes",
                java.util.Arrays.stream(ItemType.values())
                        .filter(ItemType::isForgeWeapon)
                        .toList()
        );

        return "items/edit";
    }

    /**
     * Handles the update of an existing item.
     * If there are validation errors, the edit form is shown again
     * with the allowed weapon types.
     * If the input is valid, the item is updated and the user is
     * redirected back to the forge page.
     */
    @PostMapping("/edit/{id}")
    public String updateItem(
            @PathVariable Long id,
            @Valid @ModelAttribute("updateItemDTO") UpdateItemDTO dto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("weaponTypes",
                    java.util.Arrays.stream(ItemType.values())
                            .filter(ItemType::isForgeWeapon)
                            .toList()
            );
            return "items/edit";
        }

        service.updateItem(id, dto);

        return "redirect:/items/new";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {

        service.deleteItem(id);

        return "redirect:/items/new";
    }

    /**
     * Displays the list page with all items.
     * The items can optionally be filtered by type.
     * The results are separated into forge items and shop items
     * so they are shown in two different lists.
     */
    @GetMapping
    public String listItems(
            @RequestParam(required = false) ItemType type,
            Model model) {

        List<ItemDTO> allItems = service.search(type);

        List<ItemDTO> forgeItems = allItems.stream()
                .filter(item -> item.getStatus() == ItemStatus.FORGE)
                .toList();

        List<ItemDTO> shopItems = allItems.stream()
                .filter(item -> item.getStatus() == ItemStatus.SHOP)
                .toList();

        model.addAttribute("forgeItems", forgeItems);
        model.addAttribute("shopItems", shopItems);
        model.addAttribute("weaponTypes", ItemType.values());

        return "items/list";
    }
}
