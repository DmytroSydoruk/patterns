"""Composite"""


class LaptopComponent:
    def operation(self):
        pass


class LaptopPart(LaptopComponent):
    def __init__(self, name):
        self.name = name

    def operation(self):
        return f"Laptop Part: {self.name}"


class CompositeLaptop(LaptopComponent): 
    def __init__(self, name):
        self.name = name
        self.components = []

    def add(self, component):
        self.components.append(component)

    def remove(self, component):
        self.components.remove(component)

    def operation(self):
        result = f"Laptop Model: {self.name}\n"
        for component in self.components:
            result += " - " + component.operation() + "\n"
        return result


if __name__ == "__main__":
    cpu = LaptopPart("CPU: Intel i7")
    ram = LaptopPart("RAM: 16GB")
    storage = LaptopPart("Storage: 512GB SSD")

    laptop1 = CompositeLaptop("Laptop A")
    laptop1.add(cpu)
    laptop1.add(ram)

    laptop2 = CompositeLaptop("Laptop B")
    laptop2.add(cpu)
    laptop2.add(ram)
    laptop2.add(storage)

    print(laptop1.operation())
    print(laptop2.operation())
