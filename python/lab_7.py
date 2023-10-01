"""Adapter"""


class MacbookIntel:
    def perform(self) -> None:
        print("old task")


class MacbookSilicone:
    def perform(self):
        ...


class Adapter(MacbookSilicone):
    def __init__(self, obj):
        self.old_obj = obj

    def perform(self) -> None:
        self.old_obj.perform()


if __name__ == "__main__":
    obj = MacbookIntel()
    adapter = Adapter(obj=obj)
    adapter.perform()
