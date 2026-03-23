package org.example.komplexjavautveckling.characters;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CharacterServiceTest {

    @Test
    void getClassesReturnsAllCharacterClasses() {
        CharacterRepository repository = mock(CharacterRepository.class);
        CharacterMapper mapper = new CharacterMapper();
        CharacterService service = new CharacterService(repository, mapper);

        List<CharacterClassDTO> classes = service.getClasses();

        assertEquals(CharacterClass.values().length, classes.size());
        assertEquals("MYSTIC", classes.get(0).name());
        assertEquals("Mystiker", classes.get(0).displayName());
        assertEquals(140, classes.get(0).startingPesetas());
    }

    @Test
    void createCharacterSavesCharacterWithNameAndClass() {
        CharacterRepository repository = mock(CharacterRepository.class);
        CharacterMapper mapper = new CharacterMapper();
        CharacterService service = new CharacterService(repository, mapper);

        CreateCharacterDTO dto = new CreateCharacterDTO();
        dto.setName("Mozart");
        dto.setCharacterClass(CharacterClass.MYSTIC);

        Character savedCharacter = new Character("Mozart", CharacterClass.MYSTIC);
        when(repository.save(any(Character.class))).thenReturn(savedCharacter);

        Character result = service.createCharacter(dto);

        assertEquals("Mozart", result.getName());
        assertEquals(CharacterClass.MYSTIC, result.getCharacterClass());

        verify(repository).save(any(Character.class));
    }
}
