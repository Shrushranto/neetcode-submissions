class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<heights.length; i++){
            int idx = i;
            while(!stack.isEmpty() && stack.peek()[1] >= heights[i]){
                idx = stack.peek()[0];
                maxArea = Math.max(maxArea, stack.peek()[1] * (i - idx));
                stack.pop();
            }
            stack.push(new int[]{idx, heights[i]});
        }
        while(!stack.isEmpty()){
            int[] curr = stack.pop();
            int i = curr[0];
            int h = curr[1];
            maxArea = Math.max(maxArea, (h * (heights.length - i)));
        }
        return maxArea;
    }
}
