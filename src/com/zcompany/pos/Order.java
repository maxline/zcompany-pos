package com.zcompany.pos;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static final int INITIAL_CAPACITY = 3;
    private String date;
    private String time;
    private List<OrderLine> lines;

    public Order(String date, String time) {
        this.date = date;
        this.time = time;
        lines = new ArrayList<>(INITIAL_CAPACITY);
    }

    public void makeLineItem(Product product, int quantity) {
        OrderLine line = new OrderLine(product, quantity);
        lines.add(line);
    }

    public int getTotal() {
        int total = 0;
        for (OrderLine line : lines) {
            total += line.subTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", lines=" + lines +
                ", \ntotal=" + getTotal() +
                '}';
    }
}
