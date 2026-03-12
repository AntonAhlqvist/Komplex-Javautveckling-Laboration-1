package org.example.komplexjavautveckling.controller;

import org.example.komplexjavautveckling.dto.CreateCharacterDTO;
import org.example.komplexjavautveckling.entity.Character;
import org.example.komplexjavautveckling.entity.CharacterClass;
import org.example.komplexjavautveckling.service.CharacterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @PostMapping
    public Character createCharacter(@RequestBody CreateCharacterDTO dto) {
        return service.createCharacter(dto);
    }

    @GetMapping("/classes")
    public CharacterClass[] getClasses() {
        return CharacterClass.values();
    }
}
