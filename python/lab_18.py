"""Memento Pattern"""

class LaptopMemento:
    def __init__(self, laptop):
        self.laptop = laptop

class LaptopBuyer:
    def __init__(self, name):
        self.name = name
        self.selected_laptop = None

    def select_laptop(self, laptop):
        print(f"{self.name} selected laptop: {laptop}")
        self.selected_laptop = laptop

    def create_memento(self):
        print(f"{self.name} is saving the selected laptop state.")
        return LaptopMemento(self.selected_laptop)

    def restore_from_memento(self, memento):
        if memento:
            self.selected_laptop = memento.laptop
            print(f"{self.name} restored the selected laptop: {self.selected_laptop}")


if __name__ == "__main__":
    laptop_buyer = LaptopBuyer("Alice")

    laptop_buyer.select_laptop("Dell Laptop")

    memento = laptop_buyer.create_memento()

    laptop_buyer.select_laptop("HP Laptop")

    laptop_buyer.restore_from_memento(memento)
