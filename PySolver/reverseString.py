from typing import List


def reverse_list(s: List[str]) -> None:
    left, right = 0, len(s) - 1
    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right -= 1

    print(s)


def reverse(s: List[str]) -> None:
    s.reverse()
    print(s)


def reverse_string(s: str) -> None:
    s = s[::-1]
    print(s)


if __name__ == '__main__':
    # reverseString.reverseString(["h", "e", "l", "l", "o"])
    reverse(["h", "e", "l", "l", "o"])
    reverse_string('nooyij')
