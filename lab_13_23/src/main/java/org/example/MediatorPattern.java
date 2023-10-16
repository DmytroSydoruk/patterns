package org.example;

import java.util.ArrayList;
import java.util.List;

class LaptopMediator {
    private List<LaptopBuyer> buyers = new ArrayList<>();
    private List<LaptopSeller> sellers = new ArrayList<>();

    public void addBuyer(LaptopBuyer buyer) {
        buyers.add(buyer);
    }

    public void addSeller(LaptopSeller seller) {
        sellers.add(seller);
    }

    public void buyLaptop(LaptopBuyer buyer, String laptop) {
        System.out.println(buyer.getName() + " is buying " + laptop + " from " + buyer.getSeller().getName());
        buyer.buyLaptop(laptop);
    }

    public void sellLaptop(LaptopSeller seller, String laptop) {
        System.out.println(seller.getName() + " is offering " + laptop + " for sale");
        for (LaptopBuyer buyer : buyers) {
            if (buyer.getSeller() != seller) {
                buyer.notify(laptop);
            }
        }
    }
}

class LaptopBuyer {
    private String name;
    private LaptopSeller seller;
    private LaptopMediator mediator;

    public LaptopBuyer(String name, LaptopMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public LaptopSeller getSeller() {
        return seller;
    }

    public void setSeller(LaptopSeller seller) {
        this.seller = seller;
    }

    public void buyLaptop(String laptop) {
        System.out.println(name + " has bought " + laptop);
    }

    public void notify(String laptop) {
        System.out.println(name + " received a notification: " + laptop + " is available!");
    }

    public void requestLaptop(String laptop) {
        System.out.println(name + " requests " + laptop);
        mediator.buyLaptop(this, laptop);
    }
}

class LaptopSeller {
    private String name;
    private LaptopMediator mediator;

    public LaptopSeller(String name, LaptopMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void offerLaptop(String laptop) {
        System.out.println(name + " is offering " + laptop + " for sale");
        mediator.sellLaptop(this, laptop);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        LaptopMediator mediator = new LaptopMediator();

        LaptopBuyer buyer1 = new LaptopBuyer("Alice", mediator);
        LaptopBuyer buyer2 = new LaptopBuyer("Bob", mediator);

        LaptopSeller seller1 = new LaptopSeller("Seller1", mediator);
        LaptopSeller seller2 = new LaptopSeller("Seller2", mediator);

        mediator.addBuyer(buyer1);
        mediator.addBuyer(buyer2);

        mediator.addSeller(seller1);
        mediator.addSeller(seller2);

        buyer1.setSeller(seller1);
        buyer2.setSeller(seller2);

        seller1.offerLaptop("Dell Laptop");
        seller2.offerLaptop("HP Laptop");

        buyer1.requestLaptop("Dell Laptop");
        buyer2.requestLaptop("HP Laptop");
    }
}
