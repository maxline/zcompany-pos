package com.zcompany.pos;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public int subTotal() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return "\nOrderLine{" +
                "" + product +
                ", qty=" + quantity +
                ", subTotal=" + subTotal() +
                '}';
    }
}
