class solution:
    def recursion(self, s: str) -> str:
        for char in sorted(set(s)):
            suffix = s[s.index(char):]
            if set(s) == set(suffix):
                return char + self.recursion(suffix.replace(char, ''))


if __name__ == '__main__':
    s = 'cbacdcbc'
    solution.recursion(s)
