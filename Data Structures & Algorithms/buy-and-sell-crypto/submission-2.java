class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int profit = 0;
        int r = 1;
        while(r<prices.length){
            if(prices[l] < prices[r]){
                int curProfit = prices[r] - prices[l];
                profit = Math.max(curProfit, profit);
            }else{
                l = r;
            }
            r++;
        }
        return profit;
    }
}
