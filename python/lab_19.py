"""Observer Pattern"""


class LaptopVendor:
    def __init__(self):
        self._subscribers = []
        self._laptops_in_stock = []

    def add_subscriber(self, subscriber):
        self._subscribers.append(subscriber)

    def remove_subscriber(self, subscriber):
        self._subscribers.remove(subscriber)

    def notify_subscribers(self, laptop):
        for subscriber in self._subscribers:
            subscriber.update(laptop)

    def add_laptop(self, laptop):
        self._laptops_in_stock.append(laptop)
        self.notify_subscribers(laptop)


class LaptopBuyer:
    def __init__(self, name):
        self.name = name

    def update(self, laptop):
        print(f"{self.name} received a notification: {laptop} is available!")


if __name__ == "__main__":
    laptop_vendor = LaptopVendor()

    buyer1 = LaptopBuyer("Alice")
    buyer2 = LaptopBuyer("Bob")

    laptop_vendor.add_subscriber(buyer1)
    laptop_vendor.add_subscriber(buyer2)

    laptop_vendor.add_laptop("Dell Laptop")
    laptop_vendor.add_laptop("HP Laptop")
