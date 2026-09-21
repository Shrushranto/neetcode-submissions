// base recursion
// class Solution {
//     private int getSeq(String s1, String s2, int i, int j){

//         if(i >= s1.length() || j>= s2.length()){
//             return 0;
//         }

//         int maxLen = 0;
//         if(s1.charAt(i) == s2.charAt(j)){
//             maxLen =  1 + getSeq(s1, s2, i+1, j+1);
//         }else{
//             maxLen = Math.max(getSeq(s1, s2, i, j+1), getSeq(s1, s2, i+1, j));
//         }
//         return maxLen;
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         return getSeq(text1, text2, 0, 0);
//     }
// }

// memoization
// base recursion
// class Solution {
//     private int getSeq(String s1, String s2, int i, int j, int[][] dp){

//         if(i >= s1.length() || j>= s2.length()){
//             return 0;
//         }
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
//         int maxLen = 0;
//         if(s1.charAt(i) == s2.charAt(j)){
//             maxLen =  1 + getSeq(s1, s2, i+1, j+1, dp);
//         }else{
//             maxLen = Math.max(getSeq(s1, s2, i, j+1, dp), getSeq(s1, s2, i+1, j, dp));
//         }
//         return dp[i][j] = maxLen;
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int[][] dp = new int[text1.length()][text2.length()];
//         for(int i=0; i<dp.length; i++){
//             Arrays.fill(dp[i], -1);
//         }
//         return getSeq(text1, text2, 0, 0, dp);
//     }
// }

// converting it to bottom up approach

class Solution {
    private int getSeq(String s1, String s2, int[][] dp) {
    
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        return getSeq(text1, text2, dp);
    }
}