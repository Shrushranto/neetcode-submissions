class Solution {
    private boolean checkPalindrome(int i, int j, String s, Boolean[][] dp){
        if(i>j){
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = checkPalindrome(i+1,j-1,s,dp);
        }
        return dp[i][j] = false;
    }
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        Boolean[][] dp = new Boolean [n][n];
        for(int i=0;i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                // we will check if the the string(i,j) is palindrome
                if(checkPalindrome(i,j,s,dp)){
                    count += 1;
                }
            }
        }

        return count;
    }
}
