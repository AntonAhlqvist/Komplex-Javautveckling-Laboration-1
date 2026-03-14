package org.example.komplexjavautveckling.items.dto;

import org.example.komplexjavautveckling.items.enums.ItemType;

public class CreateItemDTO {

    private String name;
    private ItemType type;
    private int damage;
    private double weight;

    public CreateItemDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ItemType getType() { return type; }
    public void setType(ItemType type) { this.type = type; }

    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}
