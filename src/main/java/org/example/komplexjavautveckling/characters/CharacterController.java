package org.example.komplexjavautveckling.characters;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
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
    public String createCharacter(
            @Valid @ModelAttribute("character") CreateCharacterDTO characterDto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("classes", characterService.getClasses());
            return "create-character";
        }

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
