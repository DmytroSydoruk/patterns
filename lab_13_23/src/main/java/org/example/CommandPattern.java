package org.example;

import java.util.ArrayList;
import java.util.List;


interface Command {
    void execute(Object item, List<Object> cart);

    void undo(Object item, List<Object> cart);
}


class CommandController {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execCommand(Object item, List<Object> cart) {
        command.execute(item, cart);
    }

    public void execUndo(Object item, List<Object> cart) {
        command.undo(item, cart);
    }
}


class AddToCartCommand implements Command {
    @Override
    public void execute(Object item, List<Object> cart) {
        cart.add(item);
    }

    @Override
    public void undo(Object item, List<Object> cart) {
        cart.remove(item);
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        List<Object> cart = new ArrayList<>();
        CommandController controller = new CommandController();
        controller.setCommand(new AddToCartCommand());

        controller.execCommand("laptop", cart);
        System.out.println(cart);

        controller.execUndo("laptop", cart);
        System.out.println(cart);
    }
}
