package org.example;
import java.util.HashMap;
import java.util.Map;

abstract class Product {
    protected String type;
    protected Map<String, Object> data;

    public abstract void create();

    @Override
    public String toString() {
        return type + "\n" + data.toString();
    }
}

class Phone extends Product {

    public Phone() {
        type = "phone";
    }

    @Override
    public void create() {
        this.data = new HashMap<>();
        this.data.put("Screen", null); // Replace null with actual data
        this.data.put("Camera", null); // Replace null with actual data
    }
}

abstract class Factory {
    public abstract Product createProduct();
}

class PhoneFactory extends Factory {
    @Override
    public Product createProduct() {
        Phone phone = new Phone();
        phone.create();
        return phone;
    }
}

public class FactoryPattern {
    public static Product client(Factory factory) {
        return factory.createProduct();
    }

    public static void main(String[] args) {
        Factory phoneFactory = new PhoneFactory();
        Product phone = client(phoneFactory);
        System.out.println(phone);
    }
}
