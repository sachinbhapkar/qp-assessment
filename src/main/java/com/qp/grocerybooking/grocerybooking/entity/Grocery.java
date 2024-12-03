package com.qp.grocerybooking.grocerybooking.entity;

import jakarta.persistence.*;

@Entity
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private String description;

    private int inventory;

    public Grocery() {
    }

    public Grocery(String name, double price, String description, int inventory) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void updateInventory(int amount) {
        this.inventory += amount;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

}
