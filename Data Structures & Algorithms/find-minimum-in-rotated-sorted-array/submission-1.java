class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int minRes = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[r] > nums[l]) {
                minRes = Math.min(minRes, nums[l]);
                r = mid - 1;
            }else if (nums[mid] >= nums[l]) {
                minRes = Math.min(minRes, nums[mid]);
                l = mid + 1;
            } else {
                minRes = Math.min(minRes, nums[mid]);
                r = mid - 1;
            }
        }

        return minRes;
    }
}
