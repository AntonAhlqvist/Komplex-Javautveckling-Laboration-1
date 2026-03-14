package org.example.komplexjavautveckling.characters;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterViewController {

    private final CharacterService characterService;

    public CharacterViewController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/")
    public String redirectToCreate() {
        return "redirect:/characters/create";
    }

    @GetMapping("/characters/create")
    public String showCreateForm(Model model) {
        model.addAttribute("character", new CreateCharacterDTO());
        model.addAttribute("classes", characterService.getClasses());
        return "create-character";
    }

    @PostMapping("/characters/create")
    public String createCharacter(@ModelAttribute CreateCharacterDTO characterDto) {
        characterService.createCharacter(characterDto);
        return "redirect:/items/new";
    }

    @GetMapping("/characters/next-step")
    public String nextStep() {
        return "next-step";
    }

    @GetMapping("/characters/classes")
    public String showClasses(Model model) {
        model.addAttribute("classes", characterService.getClasses());
        return "classes";
    }
}
