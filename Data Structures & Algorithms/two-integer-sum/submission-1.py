class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        has_seen = {}

        for i,num in enumerate(nums):
            subtract= target - num
            if subtract in has_seen:
                return [has_seen[subtract], i]
            has_seen[num] = i
        return []
        