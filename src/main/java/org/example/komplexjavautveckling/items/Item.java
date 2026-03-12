package org.example.komplexjavautveckling.items;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Namn krävs")
    private String name;

    @PositiveOrZero
    private int price;

    @NotBlank
    private String type;

    private LocalDate createdDate;

    public Item() {}

    public Item(String name, int price, String type, LocalDate createdDate) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.createdDate = createdDate;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public LocalDate getCreatedDate() { return createdDate; }

    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
}
