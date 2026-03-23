package org.example.komplexjavautveckling.characters;

import org.example.komplexjavautveckling.characters.enums.CharacterClass;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CharacterRepository extends ListCrudRepository<Character, Long> {

    List<Character> findByCharacterClass(CharacterClass characterClass);

    List<Character> findByNameContainingIgnoreCase(String name);
}
