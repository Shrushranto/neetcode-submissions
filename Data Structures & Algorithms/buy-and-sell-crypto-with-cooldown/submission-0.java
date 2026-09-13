// base recursion
// class Solution {
//     private int getProfit(int idx,int buy, int[] prices){
//         if(idx >= prices.length){
//             return 0;
//         }
//         int profit = 0;
//         if(buy == 1){
//             profit = Math.max((-prices[idx] + getProfit(idx+1,0,prices)), (getProfit(idx+1, 1,prices)));
//         }else{
//             profit = Math.max((prices[idx] + getProfit(idx+2,1,prices)), (getProfit(idx+1, 0,prices)));
//         }
//         return profit;
//     }
//     public int maxProfit(int[] prices) {
//         int profit = getProfit(0, 1, prices);
//         return profit;
//     }
// }

// memoization using DP
// class Solution {
//     private int getProfit(int idx, int buy, int[] prices, int[][] dp) {
//         if (idx >= prices.length) {
//             return 0;
//         }
//         if (dp[idx][buy] != -1) {
//             return dp[idx][buy];
//         }

//         int profit = 0;
//         if (buy == 1) {
//             profit = Math.max((-prices[idx] + getProfit(idx + 1, 0, prices, dp)), (getProfit(idx + 1, 1, prices, dp)));
//         } else {
//             profit = Math.max((prices[idx] + getProfit(idx + 2, 1, prices, dp)), (getProfit(idx + 1, 0, prices, dp)));
//         }
//         return dp[idx][buy] = profit;
//     }

//     public int maxProfit(int[] prices) {
//         int[][] dp = new int[prices.length][2];
//         for (int i = 0; i < dp.length; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         int profit = getProfit(0, 1, prices, dp);
//         return profit;
//     }
// }

// now lets remove recursive function by Bottom Up Approach that is Tabulation method
// n-1 -> 0 bottom up
// 0 -> n-1 top down
class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // +2 because we use idx + 2
        int[][] dp = new int[n + 2][2];

        // Fill from right to left
        for (int idx = n - 1; idx >= 0; idx--) {

            // buy == 1
            int buyStock = -prices[idx] + dp[idx + 1][0];

            int skipBuy = dp[idx + 1][1];

            dp[idx][1] = Math.max(buyStock, skipBuy);

            // buy == 0
            int sellStock = prices[idx] + dp[idx + 2][1];

            int skipSell = dp[idx + 1][0];

            dp[idx][0] = Math.max(sellStock, skipSell);
        }

        return dp[0][1];
    }
}