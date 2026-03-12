package org.example.komplexjavautveckling.repository;

import org.example.komplexjavautveckling.entity.Character;
import org.example.komplexjavautveckling.entity.CharacterClass;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CharacterRepository extends ListCrudRepository<Character, Long> {

    List<Character> findByCharacterClass(CharacterClass characterClass);

    List<Character> findByNameContainingIgnoreCase(String name);
}
