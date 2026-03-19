package org.example.komplexjavautveckling.items;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.komplexjavautveckling.items.enums.ItemStatus;
import org.example.komplexjavautveckling.items.enums.ItemType;

import java.time.LocalDateTime;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Namn krävs")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Föremålstyp krävs")
    private ItemType type;

    @PositiveOrZero(message = "Skada måste vara positiv eller noll")
    private int damage;

    @Positive(message = "Vikt måste vara positiv")
    private double weight;

    @PositiveOrZero
    private int price;

    private LocalDateTime createdDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @Column(nullable = false)
    private boolean createdByUser = false;

    public Item() {
    }

    public Item(String name,
                ItemType type,
                int damage,
                double weight,
                int price,
                LocalDateTime createdDate,
                ItemStatus status,
                boolean createdByUser) {

        this.name = name;
        this.type = type;
        this.damage = damage;
        this.weight = weight;
        this.price = price;
        this.createdDate = createdDate;
        this.status = status;
        this.createdByUser = createdByUser;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ItemStatus getStatus() { return status; }

    public void setStatus(ItemStatus status) { this.status = status; }

    public boolean isCreatedByUser() { return createdByUser; }

    public void setCreatedByUser(boolean createdByUser) { this.createdByUser = createdByUser; }
}
