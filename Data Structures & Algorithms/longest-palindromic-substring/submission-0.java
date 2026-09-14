class Solution {

    private boolean isPalindrome(String s, int i, int j, int[][] dp) {

        if(i >= j) {
            return true;
        }

        if(dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        if(s.charAt(i) != s.charAt(j)) {
            dp[i][j] = 0;
            return false;
        }

        dp[i][j] = isPalindrome(s, i + 1, j - 1, dp) ? 1 : 0;

        return dp[i][j] == 1;
    }

    public String longestPalindrome(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int start = 0;
        int maxLen = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {

                if(isPalindrome(s, i, j, dp)) {

                    int len = j - i + 1;

                    if(len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
