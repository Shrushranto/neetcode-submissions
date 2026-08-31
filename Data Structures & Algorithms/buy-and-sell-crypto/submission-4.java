class Solution {
    public int maxProfit(int[] prices) {
        int curPrice = prices[0]; //10
        int profit = 0;

        for(int i=1; i<prices.length; i++){
            // now we sell the stock
            int curProfit = prices[i] - curPrice; //-9..current profit of our sell could be -ve || +ve
            profit = Math.max(profit, curProfit); // this will always choose the higher profit we achieved so far
            curPrice = Math.min(curPrice, prices[i]); // always keep the minimum price
        }
        return profit;
    }
}
