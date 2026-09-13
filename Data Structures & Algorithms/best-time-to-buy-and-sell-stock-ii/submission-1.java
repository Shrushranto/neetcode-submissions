// class Solution {
//     public int maxProfit(int[] prices) {
//         int profit = 0;
        
//         if(prices.length < 1) return 0;

//         for(int i=0; i<prices.length-1; i++){
//             if(prices[i] < prices[i+1]){
//                 profit += prices[i+1] - prices[i];
//             }
//         }
//         return profit;
//     }
// }

class Solution {
    private int getProfit(int idx, int buy, int[] prices, int[][] dp) {
        if (idx == prices.length) {
            return 0;
        }
        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[idx] + getProfit(idx + 1, 0, prices, dp)),
                    (getProfit(idx + 1, 1, prices, dp)));
        } else {
            profit = Math.max((prices[idx] + getProfit(idx + 1, 1, prices, dp)),
                    (getProfit(idx + 1, 0, prices, dp)));
        }

        return dp[idx][buy]= profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }


        int profit = getProfit(0, 1, prices, dp); // limit  = 2 at most 2 transaction allowed.
        return profit;
    }
}
