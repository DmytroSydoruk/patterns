"""Builder"""
from typing import Type


class Computer:
    def __init__(self, cpu, memory, storage, gpu=None):
        self.cpu = cpu
        self.memory = memory
        self.storage = storage
        self.gpu = gpu

    def __str__(self):
        gpu_str = f", GPU: {self.gpu}" if self.gpu else ""
        return f"CPU: {self.cpu}, Memory: {self.memory},\n \
              Storage: {self.storage}{gpu_str}"
    

class ComputerBuilder:
    def set_cpu(self, cpu):
        pass

    def set_memory(self, memory):
        pass

    def set_storage(self, storage):
        pass

    def set_gpu(self, gpu):
        pass

    def build(self):
        pass


class DesktopBuilder(ComputerBuilder):
    def __init__(self):
        self.computer = Computer("Intel i7", "16GB", "512GB SSD")

    def set_gpu(self, gpu):
        self.computer.gpu = gpu

    def build(self):
        return self.computer


class LaptopBuilder(ComputerBuilder):
    def __init__(self):
        self.computer = Computer("Ryzen 5", "8GB", "256GB SSD")

    def build(self):
        return self.computer


class ComputerDirector:
    def build_computer(self, builder: Type[ComputerBuilder]) -> Computer:
        builder.set_cpu("Intel i7")
        builder.set_memory("32GB")
        builder.set_storage("1TB NVMe SSD")
        builder.set_gpu("Nvidia RTX 3080")
        return builder.build()


if __name__ == "__main__":
    builder = ComputerDirector()
    desktop_builder = DesktopBuilder()
    laptop_builder = LaptopBuilder()

    desktop = builder.build_computer(desktop_builder)
    laptop = builder.build_computer(laptop_builder)

    print("Desktop:", desktop)
    print("Laptop:", laptop)
