class Solution {
    private int helper(int idx, int prev, int[] nums, int[][]dp){
        // base case
        if(idx >= nums.length){
            return 0;
        }

        if(dp[idx][prev+1] != -2){
            return dp[idx][prev + 1];
        }

        // take the value
        int take = 0;
        if(prev == -1 || nums[prev] < nums[idx]){
            take += 1 + helper(idx+1, idx, nums, dp);
        }
        // not take case
        int nottake = helper(idx+1, prev, nums, dp);

        return dp[idx][prev+1] = Math.max(take, nottake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -2);
        }
        int length = helper(0,-1,nums, dp);
        return length;
    }
}
