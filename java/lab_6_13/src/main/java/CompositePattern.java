import java.util.ArrayList;
import java.util.List;

// Component interface
interface LaptopComponent {
    String operation();
}

// Leaf class representing individual laptop components
class LaptopPart implements LaptopComponent {
    private String name;

    public LaptopPart(String name) {
        this.name = name;
    }

    @Override
    public String operation() {
        return "Laptop Part: " + name;
    }
}

// Composite class representing a complete laptop
class CompositeLaptop implements LaptopComponent {
    private String name;
    private List<LaptopComponent> components = new ArrayList<>();

    public CompositeLaptop(String name) {
        this.name = name;
    }

    public void add(LaptopComponent component) {
        components.add(component);
    }

    public void remove(LaptopComponent component) {
        components.remove(component);
    }

    @Override
    public String operation() {
        StringBuilder result = new StringBuilder("Laptop Model: " + name + "\n");
        for (LaptopComponent component : components) {
            result.append(" - ").append(component.operation()).append("\n");
        }
        return result.toString();
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        LaptopComponent cpu = new LaptopPart("CPU: Intel i7");
        LaptopComponent ram = new LaptopPart("RAM: 16GB");
        LaptopComponent storage = new LaptopPart("Storage: 512GB SSD");

        CompositeLaptop laptop1 = new CompositeLaptop("Laptop A");
        laptop1.add(cpu);
        laptop1.add(ram);

        CompositeLaptop laptop2 = new CompositeLaptop("Laptop B");
        laptop2.add(cpu);
        laptop2.add(ram);
        laptop2.add(storage);

        System.out.println(laptop1.operation());
        System.out.println(laptop2.operation());
    }
}
