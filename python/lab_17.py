"""Mediator pattern."""

class LaptopMediator:
    def __init__(self):
        self.buyers = []
        self.sellers = []

    def add_buyer(self, buyer):
        self.buyers.append(buyer)

    def add_seller(self, seller):
        self.sellers.append(seller)

    def buy_laptop(self, buyer, laptop):
        print(f"{buyer.name} is buying {laptop} from {buyer.seller.name}")
        buyer.buy_laptop(laptop)

    def sell_laptop(self, seller, laptop):
        print(f"{seller.name} is offering {laptop} for sale")
        for buyer in self.buyers:
            if buyer.seller != seller:
                buyer.notify(laptop)

class LaptopBuyer:
    def __init__(self, name, mediator):
        self.name = name
        self.seller = None
        self.mediator = mediator

    def set_seller(self, seller):
        self.seller = seller

    def buy_laptop(self, laptop):
        print(f"{self.name} has bought {laptop}")

    def notify(self, laptop):
        print(f"{self.name} received a notification: {laptop} is available!")

    def request_laptop(self, laptop):
        print(f"{self.name} requests {laptop}")
        self.mediator.buy_laptop(self, laptop)

class LaptopSeller:
    def __init__(self, name, mediator):
        self.name = name
        self.mediator = mediator

    def offer_laptop(self, laptop):
        print(f"{self.name} is offering {laptop} for sale")
        self.mediator.sell_laptop(self, laptop)

if __name__ == "__main__":
    mediator = LaptopMediator()

    buyer1 = LaptopBuyer("Alice", mediator)
    buyer2 = LaptopBuyer("Bob", mediator)

    seller1 = LaptopSeller("Seller1", mediator)
    seller2 = LaptopSeller("Seller2", mediator)

    mediator.add_buyer(buyer1)
    mediator.add_buyer(buyer2)

    mediator.add_seller(seller1)
    mediator.add_seller(seller2)

    buyer1.set_seller(seller1)
    buyer2.set_seller(seller2)

    seller1.offer_laptop("Dell Laptop")
    seller2.offer_laptop("HP Laptop")

    buyer1.request_laptop("Dell Laptop")
    buyer2.request_laptop("HP Laptop")
