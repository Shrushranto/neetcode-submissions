class Solution {
    private int helper(int i, int j, int r, int c, int[][] grid, int[][] dp){
        
        if(i>=r || j>=c){
            return Integer.MAX_VALUE;
        }
        
        if(i == r-1 && j==c-1 ){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int rightSum = helper(i,j+1,r,c, grid, dp);
        int downSum = helper(i+1,j,r,c, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(rightSum, downSum);
    }
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        for(int i=0; i<r; i++){
            Arrays.fill(dp[i], -1);
        }
        // int minSum =  0;
        int minSum = helper(0,0, r,c, grid, dp);
        return minSum;
    }
}