package com.zcompany.pos;

public class Product {
    private String description;
    private int price;

    public Product(String description, int price) {
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[" +
                description +
                ", " + price +
                ']';
    }
}
