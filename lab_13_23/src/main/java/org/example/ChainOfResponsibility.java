package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Laptop {
    private boolean isNew;
    private boolean isInStore;

    public void createNewAndAvailable() {
        isNew = true;
        isInStore = true;
    }

    public void createUsedAndAvailable() {
        isNew = false;
        isInStore = true;
    }

    public void createNewAndUnavailable() {
        isNew = true;
        isInStore = false;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "isNew=" + isNew +
                ", isInStore=" + isInStore +
                '}';
    }

    public boolean isNew() {
        return isNew;
    }

    public boolean isInStore() {
        return isInStore;
    }
}

class LaptopFilter {
    private Predicate<Laptop> predicate;
    private LaptopFilter nextFilter;

    public LaptopFilter(Predicate<Laptop> predicate) {
        this.predicate = predicate;
    }

    public LaptopFilter setNextFilter(LaptopFilter nextFilter) {
        this.nextFilter = nextFilter;
        return nextFilter;
    }

    public List<Laptop> filter(List<Laptop> laptops) {
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            if (predicate.test(laptop)) {
                filteredLaptops.add(laptop);
            }
        }
        if (nextFilter != null) {
            return nextFilter.filter(filteredLaptops);
        }
        return filteredLaptops;
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop();
        laptop1.createNewAndAvailable();

        Laptop laptop2 = new Laptop();
        laptop2.createNewAndUnavailable();

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        LaptopFilter newFilter = new LaptopFilter(Laptop::isNew);
        LaptopFilter inStoreFilter = new LaptopFilter(Laptop::isInStore);

        newFilter.setNextFilter(inStoreFilter);

        List<Laptop> filteredLaptops = newFilter.filter(laptops);

        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}
