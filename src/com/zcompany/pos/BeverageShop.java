package com.zcompany.pos;

public class BeverageShop {
    private static final String YOUR_CASH_MESSAGE = "Your cash = ";
    private static final String YOUR_ORDER_MESSAGE = "Your order = ";
    private static final String NOT_ENOUGH_CASH_MESSAGE = "Not enough cash! Lacks = ";
    private static final String CHARGE_BACK_MESSAGE = "Cancel order! Give your charge back = ";

    private static final String NO_ORDER_MESSAGE = "Choose products and make an order, please!";
    private static final String NOT_ALLOWED_COIN_MESSAGE = "Sorry! Only 1, 5, 10, 25, 50 coins allowed!";

    private Order order;
    private int cash;

    private void printMessage(String message) {
        System.out.println(message);
    }

    private boolean isCheckOrderOk() {
        if (order == null) {
            printMessage(NO_ORDER_MESSAGE);
            return false;
        }
        return true;
    }

    public void addCash(int coin) {
        switch (coin) {
            case 1:
            case 5:
            case 10:
            case 25:
            case 50:
                cash += coin;
                break;
            default:
                printMessage(NOT_ALLOWED_COIN_MESSAGE);
        }
    }

    public void addOrder(Order currentOrder) {
        order = currentOrder;
    }

    private void giveProduct() {
        System.out.println("Take your products from " + order);
    }

    private void giveChange() {
        int change = cash - order.getTotal();
        System.out.println("Take your change = " + change);
    }

    public void makePayment() {
        printMessage(YOUR_CASH_MESSAGE + cash);
        if (!isCheckOrderOk()) return;

        printMessage(YOUR_ORDER_MESSAGE + order);

        if (cash >= order.getTotal()) {
            giveProduct();

            if (cash > order.getTotal()) {
                giveChange();
            }
        } else {
            printMessage(NOT_ENOUGH_CASH_MESSAGE + (order.getTotal() - cash));
        }
    }

    public void cancelOrder() {
        printMessage(YOUR_CASH_MESSAGE + cash);
        printMessage(YOUR_ORDER_MESSAGE + order);
        order = null;
        if (cash > 0) {
            doChargeBack();
        }
    }

    private void doChargeBack() {
        printMessage(CHARGE_BACK_MESSAGE + cash);
        cash = 0;
    }
}