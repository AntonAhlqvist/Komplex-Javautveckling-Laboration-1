package org.example.komplexjavautveckling.items;

import jakarta.validation.Valid;
import org.example.komplexjavautveckling.items.dto.CreateItemDTO;
import org.example.komplexjavautveckling.items.dto.UpdateItemDTO;
import org.example.komplexjavautveckling.items.enums.ItemType;
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

    /**
     * Displays the forge page where the user can create new weapons.
     * Only weapon types that are allowed in the forge are shown in the dropdown.
     * The forge items are displayed with pagination, five items per page.
     */
    @GetMapping("/new")
    public String showCreateForm(
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        var forgePage = service.getForgeItemsPaged(page, 5);

        model.addAttribute("createItemDTO", new CreateItemDTO());
        model.addAttribute("items", forgePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", forgePage.getTotalPages());

        model.addAttribute("weaponTypes",
                java.util.Arrays.stream(ItemType.values())
                        .filter(ItemType::isForgeWeapon)
                        .toList()
        );

        return "items/forge";
    }

    /**
     * Handles the creation of a new item from the forge form.
     * If validation fails, the forge page is shown again with the allowed
     * weapon types and the first page of existing forge items.
     * If the input is valid, the item is created and the user is redirected
     * back to the forge page.
     */
    @PostMapping("/new")
    public String createItem(
            @Valid @ModelAttribute("createItemDTO") CreateItemDTO dto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            var forgePage = service.getForgeItemsPaged(0, 5);

            model.addAttribute("items", forgePage.getContent());
            model.addAttribute("currentPage", 0);
            model.addAttribute("totalPages", forgePage.getTotalPages());

            model.addAttribute("weaponTypes",
                    java.util.Arrays.stream(ItemType.values())
                            .filter(ItemType::isForgeWeapon)
                            .toList()
            );

            return "items/forge";
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

        return "items/items-edit";
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
            return "items/items-edit";
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
     * Displays the shop page.
     * Shop items can optionally be filtered by type and are shown
     * with pagination, five items per page.
     */
    @GetMapping
    public String listItems(
            @RequestParam(required = false) ItemType type,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        var shopPage = service.getShopItemsPaged(type, page, 5);

        model.addAttribute("shopItems", shopPage.getContent());
        model.addAttribute("selectedType", type);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", shopPage.getTotalPages());
        model.addAttribute("weaponTypes", ItemType.values());

        return "items/shop";
    }
}
