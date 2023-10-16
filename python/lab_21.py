"""Strategy pattern"""


class PaymentStrategy:
    def pay(self, amount):
        pass


class CreditCardPayment(PaymentStrategy):
    def pay(self, amount):
        print(f"Paid {amount} using Credit Card")


class PayPalPayment(PaymentStrategy):
    def pay(self, amount):
        print(f"Paid {amount} using PayPal")


class ShoppingCart:
    def __init__(self):
        self.items = []
    
    def add_item(self, item):
        self.items.append(item)

    def calculate_total(self):
        return sum(item.price for item in self.items)

    def checkout(self, payment_strategy):
        total = self.calculate_total()
        payment_strategy.pay(total)


class Item:
    def __init__(self, name, price):
        self.name = name
        self.price = price


if __name__ == "__main__":
    cart = ShoppingCart()
    cart.add_item(Item("Laptop", 1000))
    cart.add_item(Item("Mouse", 20))
    
    cart.checkout(CreditCardPayment())
    cart.checkout(PayPalPayment())
