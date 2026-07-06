class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // if ((nums[i] + nums[j]) > target) {
                //     continue;
                // }

                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    long totalSum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (totalSum < target) {
                        l++;
                    } else if (totalSum > target) {
                        r--;
                    } else {
                        ansList.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;

                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    }
                }
            }
        }
        return ansList;
    }
}