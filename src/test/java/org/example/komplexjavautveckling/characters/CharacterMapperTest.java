package org.example.komplexjavautveckling.characters;

import org.example.komplexjavautveckling.characters.dto.CreateCharacterDTO;
import org.example.komplexjavautveckling.characters.enums.CharacterClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterMapperTest {

    @Test
    void toEntityCopiesNameAndCharacterClass() {
        CharacterMapper mapper = new CharacterMapper();

        CreateCharacterDTO dto = new CreateCharacterDTO();
        dto.setName("Mozart");
        dto.setCharacterClass(CharacterClass.MYSTIC);

        Character character = mapper.toEntity(dto);

        assertEquals("Mozart", character.getName());
        assertEquals(CharacterClass.MYSTIC, character.getCharacterClass());
    }
}
