"""Prototype"""
import copy
from typing import Any


class Product:
    def __init__(self):
        self.__data: dict[str, Any] = {}


    def add_item(self, key: str, value: Any):
        self.__data[key] = value


    def clone(self):
        return copy.deepcopy(self)
    

    def __repr__(self) -> str:
        return str(self.__data)


if __name__ == "__main__":
    laptop: Product = Product()
    laptop.add_item('RAM', 32)
    laptop.add_item('CPU', "Intel i7")


    laptop_second = laptop.clone()

    laptop_second.add_item('GPU', "some gpu")

    print("Prototype Data:", laptop)
    print("Clone Data:", laptop_second)
