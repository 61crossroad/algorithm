import collections
from typing import Deque


def run(s: str) -> bool:
    strs = []

    for char in s:
        if char.isalnum():
            strs.append(char.lower())

    while len(strs) > 1:
        if strs.pop(0) != strs.pop():
            return False

    return True


def run_deque(s: str) -> bool:
    strs: Deque = collections.deque()

    for char in s:
        if char.isalnum():
            strs.append(char.lower())

    while len(strs) > 1:
        if strs.popleft() != strs.pop():
            return False

    return True


if __name__ == '__main__':
    print(run('race a e car'))
    print(run_deque('race a e     car'))
