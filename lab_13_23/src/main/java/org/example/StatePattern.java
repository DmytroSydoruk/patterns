package org.example;
// State interface
interface State {
    void handle();
}

// Concrete States
class AvailableState implements State {
    @Override
    public void handle() {
        System.out.println("Laptop is available for purchase");
    }
}

class SoldOutState implements State {
    @Override
    public void handle() {
        System.out.println("Laptop is sold out");
    }
}

// Context
class StateLaptop {
    private State state;

    public StateLaptop() {
        this.state = new AvailableState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handleState() {
        state.handle();
    }
}


public class StatePattern {
    public static void main(String[] args) {
        StateLaptop laptop = new StateLaptop();

        laptop.handleState();

        laptop.setState(new SoldOutState());
        laptop.handleState();
    }
}
