class Solution {
    public int search(int[] nums, int target) {
        int pivot = -1;
        for(int i=0; i<nums.length -1; i++){
            if(nums[i] > nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1) pivot = nums.length - 1;

        int l = -1;
        int r = -1;

        if(target >= nums[0] && target <= nums[pivot]){
            l = 0;
            r = pivot;
        }else{
            l = pivot + 1;
            r = nums.length - 1;
        }

        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid + 1;
            }
        }

        return -1;
    }
}
