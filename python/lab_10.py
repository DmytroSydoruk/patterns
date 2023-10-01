"""Decorator"""


class Laptop:
    def cost(self):
        pass


class BaseLaptop(Laptop):
    def cost(self):
        return 500


class LaptopDecorator(Laptop):
    def __init__(self, laptop):
        self._laptop = laptop

    def cost(self):
        return self._laptop.cost()


class RamUpgrade(LaptopDecorator):
    def cost(self):
        return self._laptop.cost() + 100  


class StorageUpgrade(LaptopDecorator):
    def cost(self):
        return self._laptop.cost() + 150  


if __name__ == "__main__":
    basic_laptop = BaseLaptop()
    print(f"Cost of basic laptop: $ {basic_laptop.cost()}")

    laptop_with_ram = RamUpgrade(basic_laptop)
    print(f"Cost of laptop with RAM upgrade: $ {laptop_with_ram.cost()}")

    laptop_with_storage = StorageUpgrade(basic_laptop)
    print(f"Cost of laptop with storage upgrade: $ {laptop_with_storage.cost()}")

    laptop_with_ram_and_storage = StorageUpgrade(RamUpgrade(basic_laptop))
    print(f"Cost of laptop with RAM and storage upgrade: $ {laptop_with_ram_and_storage.cost()}")
