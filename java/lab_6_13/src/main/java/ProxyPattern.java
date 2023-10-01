interface LaptopP {
    String assemble();
}

// RealLaptop class
class RealLaptop implements LaptopP {
    @Override
    public String assemble() {
        return "Assembling a real laptop...";
    }
}

// LaptopProxy class
class LaptopProxy implements LaptopP {
    private RealLaptop realLaptop;

    @Override
    public String assemble() {
        if (realLaptop == null) {
            realLaptop = new RealLaptop();
        }
        return "Proxy is controlling access...\n" + realLaptop.assemble();
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        LaptopProxy proxy = new LaptopProxy();

        System.out.println("First Access:");
        System.out.println(proxy.assemble());

        System.out.println("\nSecond Access:");
        System.out.println(proxy.assemble());
    }
}
