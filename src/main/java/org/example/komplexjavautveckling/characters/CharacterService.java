package org.example.komplexjavautveckling.characters;

import org.example.komplexjavautveckling.characters.dto.CharacterClassDTO;
import org.example.komplexjavautveckling.characters.dto.CreateCharacterDTO;
import org.example.komplexjavautveckling.characters.enums.CharacterClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository repository;
    private final CharacterMapper mapper;

    public CharacterService(CharacterRepository repository, CharacterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Character createCharacter(CreateCharacterDTO dto) {
        Character character = mapper.toEntity(dto);
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
