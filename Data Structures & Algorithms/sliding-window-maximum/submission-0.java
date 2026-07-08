class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = k - 1;

        List<Integer> ans = new ArrayList<>();

        while (r < nums.length) {
            int currWindowMax = findMax(nums, l, r);
            ans.add(currWindowMax);
            r++;
            l++;
        }
        int[] arr = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }
    public int findMax(int[] nums, int s, int e) {
        int maxNo = Integer.MIN_VALUE;
        int i = s;
        while (i <= e) {
            maxNo = Math.max(maxNo, nums[i]);
            i++;
        }
        return maxNo;
    }
}
