class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(0, nums, 0);
    }

    private int helper(int idx, int[] nums, int xor) {

        if (idx == nums.length) {
            return xor;
        }

        // Take nums[idx]
        int take = helper(idx + 1, nums, xor ^ nums[idx]);

        // Don't take nums[idx]
        int skip = helper(idx + 1, nums, xor);

        return take + skip;
    }
}