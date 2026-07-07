class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0]; // let the first price be the minimum price;
        int profit = 0;

        for(int i=1;i<prices.length; i++){
            int curProfit = prices[i] - minPrice;
            profit = Math.max(curProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return profit;
    }
}
