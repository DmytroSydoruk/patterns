"""Object pool"""

class ReusablePool:

    def __init__(self, size):
        self._reusables = [Reusable() for _ in range(size)]

    def acquire(self):
        return self._reusables.pop()

    def release(self, reusable):
        self._reusables.append(reusable)


class Reusable:
    
    def __repr__(self) -> str:
        return "Obj"


def main():
    reusable_pool = ReusablePool(10)
    print(reusable_pool._reusables)
    reusable = reusable_pool.acquire()
    print(reusable_pool._reusables)
    reusable_pool.release(reusable)
    print(reusable_pool._reusables)


if __name__ == "__main__":
    main()