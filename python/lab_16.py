"""Iterator"""
from __future__ import annotations
from abc import ABC, abstractmethod
from typing import Any, List



class Iterator(ABC):
    @abstractmethod
    def has_next(self) -> bool:
        pass

    @abstractmethod
    def next(self) -> Any:
        pass


class ListIterator(Iterator):
    def __init__(self, collection: List[Any]) -> None:
        self._collection = collection
        self._index = 0

    def has_next(self) -> bool:
        return self._index < len(self._collection)

    def next(self) -> Any:
        if self.has_next():
            item = self._collection[self._index]
            self._index += 1
            return item
        else:
            raise StopIteration()



class Iterable(ABC):
    @abstractmethod
    def create_iterator(self) -> Iterator:
        pass



class ListCollection(Iterable):
    def __init__(self, collection: List[Any]) -> None:
        self._collection = collection

    def create_iterator(self) -> Iterator:
        return ListIterator(self._collection)


if __name__ == "__main__":

    collection = ListCollection(["laptop", "pc", "keyboard", "mouse", "camera"])

    iterator = collection.create_iterator()
    while iterator.has_next():
        item = iterator.next()
        print(item)
