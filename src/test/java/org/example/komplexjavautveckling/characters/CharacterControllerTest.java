package org.example.komplexjavautveckling.characters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CharacterController.class)
class CharacterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CharacterService characterService;

    @Test
    void rootRedirectsToCreatePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(redirectedUrl("/characters/create"));
    }

    @Test
    void showCreateFormReturnsCreateCharacterPage() throws Exception {
        when(characterService.getClasses()).thenReturn(List.of());

        mockMvc.perform(get("/characters/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("create-character"));
    }

    @Test
    void showClassesReturnsClassesPage() throws Exception {
        when(characterService.getClasses()).thenReturn(List.of());

        mockMvc.perform(get("/characters/classes"))
                .andExpect(status().isOk())
                .andExpect(view().name("classes"));
    }

    @Test
    void createCharacterRedirectsToItemsNew() throws Exception {
        mockMvc.perform(post("/characters/create")
                        .param("name", "Mozart")
                        .param("characterClass", "MYSTIC"))
                .andExpect(redirectedUrl("/items/new"));
    }

    @Test
    void createCharacterWithInvalidNameReturnsCreateCharacterPage() throws Exception {
        when(characterService.getClasses()).thenReturn(List.of());

        mockMvc.perform(post("/characters/create")
                        .param("name", "")
                        .param("characterClass", "MYSTIC"))
                .andExpect(status().isOk())
                .andExpect(view().name("create-character"))
                .andExpect(model().attributeExists("classes"))
                .andExpect(model().attributeHasFieldErrors("character", "name"));

        verify(characterService, never()).createCharacter(any());
    }
}
