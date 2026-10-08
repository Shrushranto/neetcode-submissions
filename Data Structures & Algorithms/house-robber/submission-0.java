class Solution {
    private int helper(int idx, int [] nums, int[] dp){
        if(idx >= nums.length){
            return 0;
        }
        // lets steal the house
        // int steal = Integer.MIN_VALUE;
        // if(idx+2 < nums.length){
        // }

        if(dp[idx] != -1){
            return dp[idx];
        }
        int steal = nums[idx] + helper(idx+2, nums, dp);
        // not steal the house
        int notSteal = helper(idx+1, nums, dp);

        return dp[idx] = Math.max(steal, notSteal);
    }
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }
}
