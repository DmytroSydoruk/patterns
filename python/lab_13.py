"""Proxy"""


class Laptop:
    def assemble(self):
        pass


class RealLaptop(Laptop):
    def assemble(self):
        return "Assembling a real laptop..."


class LaptopProxy(Laptop):
    def __init__(self):
        self.real_laptop = None

    def assemble(self):
        if self.real_laptop is None:
            self.real_laptop = RealLaptop()
        return f"Proxy is controlling access...\n{self.real_laptop.assemble()}"


if __name__ == "__main__":
    proxy = LaptopProxy()

    print("First Access:")
    print(proxy.assemble())

    print("\nSecond Access:")
    print(proxy.assemble())