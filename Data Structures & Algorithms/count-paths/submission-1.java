class Solution {
    private int helper(int r, int c, int m, int n, int[][] dp){
        if(r == m-1 && c == n-1){
            return 1;
        }
        if(r>=m || c>=n){
            return 0;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int rightMove = helper(r,c+1, m, n,dp); 
        int downMove = helper(r+1,c, m, n,dp);

        return dp[r][c] = rightMove + downMove; 
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int paths = helper(0,0,m,n,dp);
        return paths;
    }
}
