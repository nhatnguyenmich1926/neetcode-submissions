class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Step 1: store value + original index
        arr = [(val, idx) for idx, val in enumerate(nums)]
        
        # Step 2: sort by value
        arr.sort(key=lambda x: x[0])
        
        # Step 3: two pointers
        left, right = 0, len(arr) - 1
        
        while left < right:
            s = arr[left][0] + arr[right][0]
            
            if s == target:
                # Step 4: return original indices
                return [arr[left][1], arr[right][1]]
            
            if s < target:
                left += 1
            else:
                right -= 1

        