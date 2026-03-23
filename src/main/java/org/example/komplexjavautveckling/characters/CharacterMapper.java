package org.example.komplexjavautveckling.characters;

import org.example.komplexjavautveckling.characters.dto.CreateCharacterDTO;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    public Character toEntity(CreateCharacterDTO dto) {
        return new Character(
                dto.getName(),
                dto.getCharacterClass()
        );
    }
}
