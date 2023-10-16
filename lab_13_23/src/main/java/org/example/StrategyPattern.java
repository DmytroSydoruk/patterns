package org.example;


import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

// ShoppingCart class
class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public int calculateTotal() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        int total = calculateTotal();
        paymentStrategy.pay(total);
    }
}

// Item class
class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Laptop", 1000));
        cart.addItem(new Item("Mouse", 20));

        cart.checkout(new CreditCardPayment());
        cart.checkout(new PayPalPayment());
    }
}
