"""Statet Pattern"""


class State:
    def handle(self):
        pass


class AvailableState(State):
    def handle(self):
        print("Laptop is available for purchase")


class SoldOutState(State):
    def handle(self):
        print("Laptop is sold out")


class Laptop:
    def __init__(self):
        self.state = AvailableState()

    def set_state(self, state):
        self.state = state

    def handle_state(self):
        self.state.handle()


if __name__ == "__main__":
    laptop = Laptop()
    laptop.handle_state()
    laptop.set_state(SoldOutState())
    laptop.handle_state()
