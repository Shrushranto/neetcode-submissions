class Solution {
    public int maxArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        int l = 0;
        int r = heights.length - 1;

        while(l<r){
            int h = heights[l]<heights[r]?heights[l]:heights[r];
            int w = r-l;
            area = Math.max(area, h*w);

            if(heights[r] > heights[l]){
                l++;
            }else{
                r--;
            }
        }

        return area;
    }
}
