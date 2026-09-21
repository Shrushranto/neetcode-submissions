class Solution {
    private int helper(int i, int j, int r, int c, int[][]grid, int[][] dp){
        if(i>r || j>c){
            return 0;
        }
        if(grid[i][j] == 1){
            return 0;
        }
        if(i == r && j == c){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int rightMove = helper(i,j+1,r,c,grid, dp);
        int downMove = helper(i+1,j,r,c,grid, dp);

        return dp[i][j] = rightMove + downMove;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] dp = new int[r][c];
        for(int i=0; i<r; i++){
            Arrays.fill(dp[i], -1);
        }
        int paths = helper(0,0,r-1, c-1, obstacleGrid, dp);
        return paths;
    }
}