package com.zcompany.pos;

import static com.zcompany.pos.EProduct.*;

public class Run {
    public static void main(String[] args) {
        BeverageShop pos = new BeverageShop();

        exampleWithNotEnoughCash(pos);
        exampleWithCancelOrder(pos);
        exampleWithNoOrder(pos);
        exampleWithChange(pos);
        exampleWithWrongCoin(pos);
    }

    private static void addCash(BeverageShop pos, int... coins) {
        for (int coin : coins) {
            pos.addCash(coin);
        }
    }

    private static void addOrder(BeverageShop pos, EProduct... products) {
        Order order = new Order("2016", "15:00");
        for (EProduct product : products) {
            order.makeLineItem(product.getProduct(), 1);
        }

        pos.addOrder(order);
    }

    private static void exampleWithNotEnoughCash(BeverageShop pos) {
        System.out.println("1. EXAMPLE WITH NOT ENOUGH CASH");
        addCash(pos, 50, 5, 1);
        addOrder(pos, COFFEE, COFFEE, TEA);
        pos.makePayment();
    }

    private static void exampleWithCancelOrder(BeverageShop pos) {
        System.out.println("\n2. EXAMPLE WITH CANCEL ORDER");
        addCash(pos, 50, 5, 1);
        addOrder(pos, COFFEE, JUICE, TEA);
        pos.cancelOrder();
    }

    private static void exampleWithNoOrder(BeverageShop pos) {
        System.out.println("\n3. EXAMPLE WITH NO ORDER");
        addCash(pos, 50, 5, 1);
        pos.makePayment();
    }

    private static void exampleWithChange(BeverageShop pos) {
        System.out.println("\n4. EXAMPLE WITH CHANGE");
        addCash(pos, 50, 50, 25, 5);
        addOrder(pos, COFFEE, JUICE, TEA);
        pos.makePayment();
    }

    private static void exampleWithWrongCoin(BeverageShop pos) {
        System.out.println("\n5. EXAMPLE WITH WRONG COIN");
        addCash(pos, 51, 26);
    }
}