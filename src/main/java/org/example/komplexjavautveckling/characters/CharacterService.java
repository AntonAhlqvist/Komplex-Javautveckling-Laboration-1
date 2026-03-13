package org.example.komplexjavautveckling.characters;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) { this.repository = repository; }

    public Character createCharacter(CreateCharacterDTO dto) {
        Character character = new Character(
                dto.getName(),
                dto.getCharacterClass()
        );

        return repository.save(character);
    }

    public List<CharacterClassDTO> getClasses() {
        List<CharacterClassDTO> dtos = new ArrayList<>();
        for (CharacterClass cc : CharacterClass.values()) {
            dtos.add(new CharacterClassDTO(
                    cc.name(),
                    cc.getDisplayName(),
                    cc.getStartingPesetas()
            ));
        }
        return dtos;
    }
}
