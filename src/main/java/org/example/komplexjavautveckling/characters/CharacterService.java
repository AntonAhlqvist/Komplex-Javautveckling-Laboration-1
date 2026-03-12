package org.example.komplexjavautveckling.characters;

import org.springframework.stereotype.Service;

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
}
