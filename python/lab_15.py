"""Command pattern"""
from typing import Any
from abc import ABC, abstractmethod


class CommandController:
    def __init__(self) -> None:
        self._command = None

    def set_command(self, command) -> None:
        self._command = command

    def exec_command(self, *args, **kwags):
        self._command.execute(*args, **kwags)

    def exec_undo(self, *args, **kwags): 
        self._command.undo(*args, **kwags)



class Command(ABC):
    @abstractmethod
    def execute():
        pass

    @abstractmethod
    def undo():
        pass

class AddToCartCommand(Command):

    def execute(self, item: Any, cart: list) -> list:
        cart.append(item)


    def undo(self, item: Any, cart: list) -> list:
        if item in cart: 
            cart.remove(item)

    
if __name__ == "__main__": 
    cart: list = list()

    controller: CommandController = CommandController()
    controller.set_command(AddToCartCommand())

    controller.exec_command(item="laptop", cart=cart)
    print(cart)
    controller.exec_undo(item="laptop", cart=cart)
    print(cart)
    