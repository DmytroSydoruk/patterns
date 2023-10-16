package org.example;

class LaptopMemento {
    private String laptop;

    public LaptopMemento(String laptop) {
        this.laptop = laptop;
    }

    public String getLaptop() {
        return laptop;
    }
}

class LaptopBuyerMomento {
    private String name;
    private String selectedLaptop;

    public LaptopBuyerMomento(String name) {
        this.name = name;
    }

    public void selectLaptop(String laptop) {
        System.out.println(name + " selected laptop: " + laptop);
        selectedLaptop = laptop;
    }

    public LaptopMemento createMemento() {
        System.out.println(name + " is saving the selected laptop state.");
        return new LaptopMemento(selectedLaptop);
    }

    public void restoreFromMemento(LaptopMemento memento) {
        if (memento != null) {
            selectedLaptop = memento.getLaptop();
            System.out.println(name + " restored the selected laptop: " + selectedLaptop);
        }
    }
}

public class MomentoPattern {
    public static void main(String[] args) {
        LaptopBuyerMomento laptopBuyer = new LaptopBuyerMomento("Alice");

        laptopBuyer.selectLaptop("Dell Laptop");

        LaptopMemento memento = laptopBuyer.createMemento();

        laptopBuyer.selectLaptop("HP Laptop");

        laptopBuyer.restoreFromMemento(memento);
    }
}
