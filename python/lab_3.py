"""Factory"""
from typing import Any, Type
from abc import ABC, abstractmethod


class Product(ABC):

    __slots__ : list[str] = ["__type", "__data"]

    __type: str
    __data: dict[str, Any]

    @abstractmethod
    def create(self):
        pass

    def __repr__(self) -> str:
        return f"{self.__type}\n{self.__data}"


class Phone(Product):

    def __init__(self) -> None:
        # super().__init__()
        self.__type: str = "phone"

    def create(self):
        self.__data = {
            "Screen": ... ,
            "Camera": ... ,
        }
        return self.__repr__()
    
    def __repr__(self) -> str:
        return f"{self.__type}\n{self.__data}"


class Factory(ABC):
    @abstractmethod
    def create_product(self):
        pass

class PhoneFactory(Factory):

    def create_product(self):
        return Phone()


def client(factory: Type[Factory]) -> Type[Product]:
    product: Type[Product] = factory.create_product()
    return product.create()


if __name__ == "__main__":
    phone_factory: PhoneFactory = PhoneFactory()
    phone = client(phone_factory)
    print(phone)  
