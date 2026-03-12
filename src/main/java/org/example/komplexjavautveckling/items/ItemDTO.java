package org.example.komplexjavautveckling.items;

import java.time.LocalDate;

public class ItemDTO {

    private Long id;
    private String name;
    private int price;
    private String type;
    private LocalDate createdDate;

    public ItemDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
}
