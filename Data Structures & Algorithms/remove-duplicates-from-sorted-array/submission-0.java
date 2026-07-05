class Solution {
    public int removeDuplicates(int[] nums) {
        int noPlacement = 1;
        int curIdx = 1;
        while(curIdx < nums.length){
            if(nums[curIdx] == nums[curIdx - 1]){
                curIdx++;
            }else{
                nums[noPlacement++] = nums[curIdx++];
            }
        }

        return noPlacement;
    }
}