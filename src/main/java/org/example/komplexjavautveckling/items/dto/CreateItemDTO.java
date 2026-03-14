package org.example.komplexjavautveckling.items.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.komplexjavautveckling.items.enums.ItemType;

public class CreateItemDTO {

    @NotBlank(message = "Namn krävs")
    private String name;

    @NotNull(message = "Föremålstyp krävs")
    private ItemType type;

    @PositiveOrZero(message = "Skada måste vara positiv eller noll")
    private int damage;

    @Positive(message = "Vikt måste vara positiv")
    private double weight;

    public CreateItemDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
