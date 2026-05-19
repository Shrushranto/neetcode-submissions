class Solution {
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;

        while(i<=r){
            if(nums[i] == 0){
                swap(i,l, nums);
                l++;
                i++;
            }else if(nums[i] == 2){
                swap(i,r,nums);
                r--;
            }else{
                i++;
            }
        }
    }
}