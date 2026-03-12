package org.example.komplexjavautveckling.characters;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCharacterDTO {

    @NotBlank(message = "Namn krävs")
    private String name;

    @NotNull(message = "Karaktärsklass krävs")
    private CharacterClass characterClass;

    public CreateCharacterDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CharacterClass getCharacterClass() { return characterClass; }
    public void setCharacterClass(CharacterClass characterClass) { this.characterClass = characterClass; }
}
