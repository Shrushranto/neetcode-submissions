class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxL = height[l];
        int maxR = height[height.length - 1];

        int totalWater = 0;
        while (l < r) {
            if (maxL <= maxR) {
                totalWater += maxL - height[l];
                l++;
                maxL = Math.max(height[l], maxL);

            } else {
                totalWater += maxR - height[r];
                r--;
                maxR = Math.max(height[r], maxR);
            }
        }
        return totalWater;
    }
}
