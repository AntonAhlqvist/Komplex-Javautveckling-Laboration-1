package org.example.komplexjavautveckling.items;

import org.example.komplexjavautveckling.items.enums.ItemStatus;
import org.example.komplexjavautveckling.items.enums.ItemType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ItemService service;

    @Test
    void showCreateFormReturnsForgePage() throws Exception {
        when(service.getForgeItemsPaged(0, 10)).thenReturn(new PageImpl<>(List.of()));

        mockMvc.perform(get("/items/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("items/forge"))
                .andExpect(model().attributeExists("createItemDTO"))
                .andExpect(model().attributeExists("items"))
                .andExpect(model().attributeExists("weaponTypes"));
    }

    @Test
    void listItemsReturnsShopPage() throws Exception {
        when(service.getShopItemsPaged(null, 0, 10, null, null))
                .thenReturn(new PageImpl<>(List.of()));

        mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(view().name("items/shop"))
                .andExpect(model().attributeExists("shopItems"))
                .andExpect(model().attributeExists("weaponTypes"));
    }

    @Test
    void showEditFormReturnsEditPage() throws Exception {
        Item item = new Item(
                "Kortsvärd",
                ItemType.SWORD,
                10,
                2.5,
                20,
                LocalDateTime.now(),
                ItemStatus.FORGE,
                true
        );

        when(service.getEntityById(1L)).thenReturn(item);

        mockMvc.perform(get("/items/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("items/items-edit"))
                .andExpect(model().attributeExists("updateItemDTO"))
                .andExpect(model().attributeExists("itemId"))
                .andExpect(model().attributeExists("weaponTypes"));
    }

    @Test
    void createItemInvalidPostReturnsForgePage() throws Exception {
        when(service.getForgeItemsPaged(0, 10)).thenReturn(new PageImpl<>(List.of()));

        mockMvc.perform(post("/items/new")
                        .param("name", "")
                        .param("type", "DAGGER")
                        .param("damage", "")
                        .param("weight", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("items/forge"))
                .andExpect(model().attributeExists("items"))
                .andExpect(model().attributeExists("weaponTypes"))
                .andExpect(model().attributeHasFieldErrors("createItemDTO", "name", "damage", "weight"));
    }

    @Test
    void createItemValidPostRedirectsToItemsNew() throws Exception {
        mockMvc.perform(post("/items/new")
                        .param("name", "Ankdolk")
                        .param("type", "DAGGER")
                        .param("damage", "6")
                        .param("weight", "1.5"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/items/new"));

        verify(service).createItem(any());
    }

    @Test
    void deleteItemRedirectsToItemsNew() throws Exception {
        mockMvc.perform(post("/items/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/items/new"));

        verify(service).deleteItem(1L);
    }
}
