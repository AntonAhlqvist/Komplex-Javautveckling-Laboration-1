package org.example.komplexjavautveckling.mapper;

import org.example.komplexjavautveckling.dto.CreateCharacterDTO;
import org.example.komplexjavautveckling.entity.Character;
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
