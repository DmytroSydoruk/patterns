package org.example;

class Computer {
    private String cpu;
    private String memory;
    private String storage;
    private String gpu;

    public Computer(String cpu, String memory, String storage, String gpu) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        String gpuStr = (gpu != null) ? ", GPU: " + gpu : "";
        return "CPU: " + cpu + ", Memory: " + memory + ",\nStorage: " + storage + gpuStr;
    }

    public String getCPU() {
        return cpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getStorage() {
        return storage;
    }

    public String getGPU() {
        return gpu;
    }
}

interface ComputerBuilder {
    void setCPU(String cpu);
    void setMemory(String memory);
    void setStorage(String storage);
    void setGPU(String gpu);
    Computer build();
}

class DesktopBuilder implements ComputerBuilder {
    private Computer computer;

    public DesktopBuilder() {
        computer = new Computer("Intel i7", "16GB", "512GB SSD", null);
    }

    public void setGPU(String gpu) {
        computer = new Computer(computer.getCPU(), computer.getMemory(), computer.getStorage(), gpu);
    }

    public void setCPU(String cpu) {
        computer = new Computer(cpu, computer.getMemory(), computer.getStorage(), computer.getGPU());
    }

    public void setMemory(String memory) {
        computer = new Computer(computer.getCPU(), memory, computer.getStorage(), computer.getGPU());
    }

    public void setStorage(String storage) {
        computer = new Computer(computer.getCPU(), computer.getMemory(), storage, computer.getGPU());
    }

    public Computer build() {
        return computer;
    }
}

class LaptopBuilder implements ComputerBuilder {
    private Computer computer;

    public LaptopBuilder() {
        computer = new Computer("Ryzen 5", "8GB", "256GB SSD", null);
    }

    public void setCPU(String cpu) {
        computer = new Computer(cpu, computer.getMemory(), computer.getStorage(), computer.getGPU());
    }

    public void setMemory(String memory) {
        computer = new Computer(computer.getCPU(), memory, computer.getStorage(), computer.getGPU());
    }

    public void setStorage(String storage) {
        computer = new Computer(computer.getCPU(), computer.getMemory(), storage, computer.getGPU());
    }

    @Override
    public void setGPU(String gpu) {
        computer = new Computer(computer.getCPU(), computer.getMemory(), computer.getStorage(), gpu);
    }

    public Computer build() {
        return computer;
    }
}

class ComputerDirector {
    public Computer buildComputer(ComputerBuilder builder) {
        builder.setCPU("Intel i7");
        builder.setMemory("32GB");
        builder.setStorage("1TB NVMe SSD");
        builder.setGPU("Nvidia RTX 3080");
        return builder.build();
    }
}

public class Builder {
    public static void main(String[] args) {
        ComputerDirector builder = new ComputerDirector();
        ComputerBuilder desktopBuilder = new DesktopBuilder();
        ComputerBuilder laptopBuilder = new LaptopBuilder();

        Computer desktop = builder.buildComputer(desktopBuilder);
        Computer laptop = builder.buildComputer(laptopBuilder);

        System.out.println("Desktop: " + desktop);
        System.out.println("Laptop: " + laptop);
    }
}
