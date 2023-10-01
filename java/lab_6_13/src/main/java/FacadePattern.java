// Subsystem classes
class CPU {
    public String getInfo() {
        return "CPU: Intel i7";
    }
}

class RAM {
    public String getInfo() {
        return "RAM: 16GB";
    }
}

class Storage {
    public String getInfo() {
        return "Storage: 512GB SSD";
    }
}

class GPU {
    public String getInfo() {
        return "GPU: Nvidia RTX 3080";
    }
}

// Facade class
class LaptopFacade {
    private CPU cpu;
    private RAM ram;
    private Storage storage;
    private GPU gpu;

    public LaptopFacade() {
        this.cpu = new CPU();
        this.ram = new RAM();
        this.storage = new Storage();
        this.gpu = new GPU();
    }

    public String assembleHighEndLaptop() {
        String[] components = {
                cpu.getInfo(),
                ram.getInfo(),
                storage.getInfo(),
                gpu.getInfo()
        };
        return String.join("\n", components);
    }

    public String assembleBasicLaptop() {
        String[] components = {
                cpu.getInfo(),
                ram.getInfo(),
                storage.getInfo()
        };
        return String.join("\n", components);
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        LaptopFacade facade = new LaptopFacade();

        System.out.println("High-End Laptop Configuration:");
        String highEndConfig = facade.assembleHighEndLaptop();
        System.out.println(highEndConfig);

        System.out.println("\nBasic Laptop Configuration:");
        String basicConfig = facade.assembleBasicLaptop();
        System.out.println(basicConfig);
    }
}
