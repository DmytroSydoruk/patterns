package org.example;

public class Singleton {
    private static Singleton instance;
    public String value;
    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
    public void showMessage() {
        System.out.println(this.value);
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance("Laptop");
        Singleton singleton2 = Singleton.getInstance("PC");

        singleton1.showMessage();
        singleton2.showMessage();

        System.out.println(singleton1 == singleton2); // Output: true
    }
}