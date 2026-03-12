package org.example.komplexjavautveckling.service;

import org.example.komplexjavautveckling.dto.CreateCharacterDTO;
import org.example.komplexjavautveckling.entity.Character;
import org.example.komplexjavautveckling.repository.CharacterRepository;
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
