class Solution:
    def recursion(self, s: str) -> str:
        for char in sorted(set(s)):
            suffix = s[s.index(char):]
            if set(s) == set(suffix):
                return char + self.recursion(suffix.replace(char, ''))
        return ''


if __name__ == '__main__':
    s = 'cbacdcbc'
    print(Solution().recursion(s))
