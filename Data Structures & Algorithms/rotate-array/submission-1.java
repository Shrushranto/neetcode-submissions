class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        //reverse first half
        reverse(nums, 0, nums.length - 1);
        //reverse second half
        reverse(nums, 0, k-1);
        // // reverse whole array
        reverse(nums,k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end){
        int l = start;
        int r = end;

        while(l<r){
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}