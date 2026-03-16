package org.example.komplexjavautveckling.items.dto;

import org.example.komplexjavautveckling.items.enums.ItemStatus;
import org.example.komplexjavautveckling.items.enums.ItemType;

import java.time.LocalDate;

public class ItemDTO {

    private Long id;
    private String name;
    private ItemType type;
    private int damage;
    private double weight;
    private int price;
    private LocalDate createdDate;
    private ItemStatus status;

    public ItemDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ItemType getType() { return type; }
    public void setType(ItemType type) { this.type = type; }

    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

    public ItemStatus getStatus() { return status; }
    public void setStatus(ItemStatus status) { this.status = status; }
}
