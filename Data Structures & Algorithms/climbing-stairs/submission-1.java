class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n,0, dp);
    }
    public int solve(int s, int ini, int dp[]){
        if(ini == s) return 1;
        if(ini > s) return 0;

        if(dp[ini] != -1){
            return dp[ini];
        }
        int oneStep = solve(s,ini + 1, dp);
        int twoStep = solve(s,ini + 2, dp);

        dp[ini] = oneStep + twoStep;
        return dp[ini];
    }
}
