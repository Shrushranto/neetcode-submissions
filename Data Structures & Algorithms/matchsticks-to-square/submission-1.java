class Solution {

    
    private boolean used[];
    private int target;
    private int n;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i : matchsticks) sum += i;
        if(sum % 4 != 0) return false;

        this.target = sum/4;
        this.n = matchsticks.length;
        this.used = new boolean[n];
        Arrays.sort(matchsticks);
        for(int i=0; i<n/2; i++){
            int t = matchsticks[i];
            matchsticks[i] = matchsticks[n - i - 1];
            matchsticks[n - i - 1] = t;
        }

        boolean ans = helper(matchsticks, 4, 0, 0); // helper(matchsticks, k, idx, curSum)
        return ans;
    }

    private boolean helper(int[] matchsticks, int k, int idx, int curSum){
        if(k == 0){
            return true;
        }

        if(curSum == target){
            return helper(matchsticks, k-1, 0, 0);
        }

        for(int j=idx; j<n; j++){
            if(used[j] != false || curSum + matchsticks[j] > target){
                continue;
            }

            used[j] = true;
            if(helper(matchsticks, k, j+1, curSum + matchsticks[j])) return true;
            used[j] = false;
        }

        return false;
    }
}