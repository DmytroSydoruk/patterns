"""Facade"""


class CPU:
    def get_info(self):
        return "CPU: Intel i7"


class RAM:
    def get_info(self):
        return "RAM: 16GB"


class Storage:
    def get_info(self):
        return "Storage: 512GB SSD"


class GPU:
    def get_info(self):
        return "GPU: Nvidia RTX 3080"


class LaptopFacade:
    def __init__(self):
        self.cpu = CPU()
        self.ram = RAM()
        self.storage = Storage()
        self.gpu = GPU()

    def assemble_high_end_laptop(self):
        components = [
            self.cpu.get_info(),
            self.ram.get_info(),
            self.storage.get_info(),
            self.gpu.get_info()
        ]
        return "\n".join(components)

    def assemble_basic_laptop(self):
        components = [
            self.cpu.get_info(),
            self.ram.get_info(),
            self.storage.get_info()
        ]
        return "\n".join(components)


if __name__ == "__main__":
    facade = LaptopFacade()

    print("High-End Laptop Configuration:")
    high_end_config = facade.assemble_high_end_laptop()
    print(high_end_config)

    print("\nBasic Laptop Configuration:")
    basic_config = facade.assemble_basic_laptop()
    print(basic_config)