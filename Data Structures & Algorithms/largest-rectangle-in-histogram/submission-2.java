class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            int ind = i;
            while(!stack.isEmpty() && stack.peek()[1] >= heights[i]){
                maxArea = Math.max(maxArea, (i-stack.peek()[0]) * stack.peek()[1]);
                ind = stack.peek()[0];
                stack.pop();
            }
            stack.push(new int[]{ind, heights[i]});
        }

        while(!stack.isEmpty()){
            maxArea = Math.max(maxArea, ((heights.length)-stack.peek()[0]) * stack.peek()[1]);
            stack.pop();
        }
        return maxArea;
    }
}
