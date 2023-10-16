package org.example;

import java.util.ArrayList;
import java.util.List;


class LaptopVendor {
    private List<LaptopBuyerObserver> subscribers = new ArrayList<>();
    private List<String> laptopsInStock = new ArrayList<>();

    public void addSubscriber(LaptopBuyerObserver subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(LaptopBuyerObserver subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String laptop) {
        for (LaptopBuyerObserver subscriber : subscribers) {
            subscriber.update(laptop);
        }
    }

    public void addLaptop(String laptop) {
        laptopsInStock.add(laptop);
        notifySubscribers(laptop);
    }
}

// Observer
class LaptopBuyerObserver {
    private String name;

    public LaptopBuyerObserver(String name) {
        this.name = name;
    }

    public void update(String laptop) {
        System.out.println(name + " received a notification: " + laptop + " is available!");
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        LaptopVendor laptopVendor = new LaptopVendor();

        LaptopBuyerObserver buyer1 = new LaptopBuyerObserver("Alice");
        LaptopBuyerObserver buyer2 = new LaptopBuyerObserver("Bob");

        laptopVendor.addSubscriber(buyer1);
        laptopVendor.addSubscriber(buyer2);

        laptopVendor.addLaptop("Dell Laptop");
        laptopVendor.addLaptop("HP Laptop");
    }
}
