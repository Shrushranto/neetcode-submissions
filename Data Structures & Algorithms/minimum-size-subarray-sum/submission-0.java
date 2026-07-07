class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minWindowSize = Integer.MAX_VALUE;

        int l=0;
        int r = 0;
        int curSum = 0;
        while(r<nums.length){

            curSum += nums[r];
            while(curSum >= target){
                minWindowSize = Math.min(minWindowSize, r-l+1);
                curSum -= nums[l];
                l++;
            }
            r++;
        }
        return minWindowSize == Integer.MAX_VALUE? 0 : minWindowSize;
    }
}