package org.example;
import java.util.HashMap;
import java.util.Map;

class Prototype implements Cloneable {
    private Map<String, String> data;

    public Prototype() {
        data = new HashMap<>();
    }

    public void addItem(String key, String value) {
        data.put(key, value);
    }

    @Override
    public Prototype clone() {
        Prototype clone = null;
        try {
            clone = (Prototype) super.clone();
            clone.data = new HashMap<>(this.data);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public void showData() {
        System.out.println(data);
    }

    public static void main(String[] args) {
        Prototype laptop = new Prototype();
        laptop.addItem("CPU", "Intel i7");
        laptop.addItem("RAM", "16");

        Prototype laptopSecond = laptop.clone();

        laptopSecond.addItem("GPU", "some gpu");

        System.out.print("Prototype Data: ");
        laptop.showData();

        System.out.print("Clone Data: ");
        laptopSecond.showData();
    }
}
