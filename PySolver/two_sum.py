from typing import List


def brute_force(nums: List[int], target: int) -> List[int]:
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]


def in_search(nums: List[int], target: int) -> List[int]:
    for i, n in enumerate(nums): # index, value
        complement = target - n

        if complement in nums[i + 1:]:
            return [nums.index(n), nums[i + 1:].index(complement) + (i + 1)]


def dict_map(nums: List[int], target: int) -> List[int]:
    nums_map = {}
    for i, num in enumerate(nums):
        nums_map[num] = i

    for i, num in enumerate(nums):
        if target - num in nums_map and i != nums_map[target - num]:
            return [i, nums_map[target - num]]


def dict_map_one(nums: List[int], target: int) -> List[int]:
    nums_map = {}
    for i, num in enumerate(nums):
        if target - num in nums_map:
            return [nums_map[target - num], i]
        nums_map[num] = i


if __name__ == '__main__':
    nums = [2, 7, 11, 15]
    target = 9
    # print(brute_force(nums, target))
    # print(in_search(nums, target))
    # print(dict_map(nums, target))
    print(dict_map_one(nums, target))
