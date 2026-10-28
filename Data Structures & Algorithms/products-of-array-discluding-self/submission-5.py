class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # building prefix
        prefix = [1]*n
        prefix[0] = 1

        # building suffix
        suffix = [1]*n
        suffix[len(nums) - 1] = 1

        for i in range(1,len(nums)):
            prefix[i] = prefix[i-1] * nums[i-1]

        for j in range(len(nums) - 2, -1, -1):
            suffix[j] = suffix[j+1] * nums[j+1]

        ans = []
        for i in range(len(nums)):
            ans.append(prefix[i] * suffix[i])
        
        return ans
