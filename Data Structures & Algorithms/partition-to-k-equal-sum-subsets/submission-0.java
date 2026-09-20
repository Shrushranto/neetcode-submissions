class Solution {
    private boolean used[];
    private int target;
    private int n;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % k != 0) return false;

        this.target = sum/k;
        this.n = nums.length;
        this.used = new boolean[n];
        Arrays.sort(nums);
        for(int i=0; i<n/2; i++){
            int t = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = t;
        }

        boolean ans = helper(nums, k, 0, 0); // helper(nums, k, idx, curSum)
        return ans;
    }

    private boolean helper(int[] nums, int k, int idx, int curSum){
        if(k == 0){
            return true;
        }

        if(curSum == target){
            return helper(nums, k-1, 0, 0);
        }

        for(int j=idx; j<n; j++){
            if(used[j] != false || curSum + nums[j] > target){
                continue;
            }

            used[j] = true;
            if(helper(nums, k, j+1, curSum + nums[j])) return true;
            used[j] = false;
        }

        return false;
    }
}