package org.example.komplexjavautveckling.characters;

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
