package org.example.komplexjavautveckling.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Namn krävs")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Karaktärsklass krävs")
    private CharacterClass characterClass;

    @PositiveOrZero
    private int pesetas;

    private LocalDate createdDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> inventory = new ArrayList<>();

    public Character() {
    }

    public Character(String name, CharacterClass characterClass) {

        this.name = name;
        this.characterClass = characterClass;
        this.pesetas = characterClass.getStartingPesetas();
        this.createdDate = LocalDate.now();
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public CharacterClass getCharacterClass() { return characterClass; }

    public void setCharacterClass(CharacterClass characterClass) { this.characterClass = characterClass; }

    public int getPesetas() { return pesetas; }

    public void setPesetas(int pesetas) { this.pesetas = pesetas; }

    public LocalDate getCreatedDate() { return createdDate; }

    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

    public List<Item> getInventory() { return inventory; }

    public void setInventory(List<Item> inventory) { this.inventory = inventory; }
}
