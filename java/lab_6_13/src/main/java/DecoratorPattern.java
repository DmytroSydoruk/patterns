
interface Laptop {
    int cost();
}


class BaseLaptop implements Laptop {
    @Override
    public int cost() {
        return 500;
    }
}


abstract class LaptopDecorator implements Laptop {
    protected Laptop laptop;

    public LaptopDecorator(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public int cost() {
        return laptop.cost();
    }
}


class RamUpgrade extends LaptopDecorator {
    public RamUpgrade(Laptop laptop) {
        super(laptop);
    }

    @Override
    public int cost() {
        return super.cost() + 100;
    }
}

class StorageUpgrade extends LaptopDecorator {
    public StorageUpgrade(Laptop laptop) {
        super(laptop);
    }

    @Override
    public int cost() {
        return super.cost() + 150;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Laptop basicLaptop = new BaseLaptop();
        System.out.println("Cost of basic laptop: $" + basicLaptop.cost());

        Laptop laptopWithRam = new RamUpgrade(basicLaptop);
        System.out.println("Cost of laptop with RAM upgrade: $" + laptopWithRam.cost());

        Laptop laptopWithStorage = new StorageUpgrade(basicLaptop);
        System.out.println("Cost of laptop with storage upgrade: $" + laptopWithStorage.cost());

        Laptop laptopWithRamAndStorage = new StorageUpgrade(new RamUpgrade(basicLaptop));
        System.out.println("Cost of laptop with RAM and storage upgrade: $" + laptopWithRamAndStorage.cost());
    }
}
