from typing import List


class Solution:
    def reverse_list(self, s: List[str]) -> None:
        left, right = 0, len(s) - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1

        print(s)

    def reverse(self, s: List[str]) -> None:
        s.reverse()
        print(s)

    def reverse_string(self, s: str) -> None:
        s = s[::-1]
        print(s)


if __name__ == '__main__':
    # Solution.reverse_list(["h", "e", "l", "l", "o"])
    Solution().reverse(["h", "e", "l", "l", "o"])
    Solution().reverse_string('nooyij')
