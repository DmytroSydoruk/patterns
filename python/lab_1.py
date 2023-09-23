"""Singleton"""
from typing import Any


class Cart:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Cart, cls).__new__(cls)
            cls._instance.value = None
        return cls._instance

    def set_value(self, value):
        self.value: Any = value

    def get_value(self) -> Any:
        return self.value
    

if __name__ == "__main__":
    exp1: Cart = Cart()
    exp2: Cart = Cart()

    exp1.set_value(("bread", "cola"))

    print(exp1.get_value())  # Output: Hello, Singleton!
    print(exp2.get_value())  # Output: Hello, Singleton!
    print(exp1 is exp2)  # Output: True
    