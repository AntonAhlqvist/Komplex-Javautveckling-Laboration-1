package org.example.komplexjavautveckling.items.dto;

import jakarta.validation.constraints.*;
import org.example.komplexjavautveckling.items.enums.ItemType;

public class UpdateItemDTO {

    @NotBlank(message = "Namn krävs")
    private String name;

    @NotNull(message = "Typ krävs")
    private ItemType type;

    @NotNull(message = "Skada krävs")
    @Min(value = 1, message = "Skada måste vara minst 1")
    private Integer damage;

    @NotNull(message = "Vikt krävs")
    @DecimalMin(value = "0.1", message = "Vikt måste vara minst 0.1")
    private Double weight;

    public UpdateItemDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ItemType getType() { return type; }
    public void setType(ItemType type) { this.type = type; }

    public Integer getDamage() { return damage; }
    public void setDamage(Integer damage) { this.damage = damage; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
}
