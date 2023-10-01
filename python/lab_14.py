"""Chain of Responsibility"""
from typing import Callable


class Laptop:

    def __init__(self) -> None:
        self.new: bool
        self.in_store: bool
    
    def create_new_and_aviable(self) -> None:
        self.new = True
        self.in_store = True

    def create_used_and_aviable(self):
        self.new = False
        self.in_store = True

    def create_new_and_unaviable(self):
        self.new = True
        self.in_store = False

    def __repr__(self) -> str:
        return str({"new": self.new, "in_store": self.in_store})


def check_new(obj: Laptop) -> bool:
    return True if obj.new is True else False



def filter_chain(obj: Laptop, validations: list[Callable]) -> None:
    buffer: Laptop | None 
    for validation in validations:
        if validation(obj) is True:
            buffer = obj
        else: 
            buffer = None
    return buffer

if __name__ == "__main__":
    laptop: Laptop = Laptop()
    laptop.create_new_and_aviable()
    validations: list[Callable] = [check_new]
    print(filter_chain(obj=laptop, validations=validations))