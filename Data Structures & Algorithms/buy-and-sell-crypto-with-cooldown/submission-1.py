class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        def helper(idx, b, prices, dp):

            if(idx >= len(prices)):
                return 0
            
            if(dp[idx][b] != -1):
                return dp[idx][b]
            
            profit = 0

            if(b == 1): # we are allowed to buy
                profit = max(
                    (-prices[idx] + helper(idx+1, 0, prices, dp)), (helper(idx+1, 1, prices, dp))
                )
            else: #buy == 0, means we can sell
                profit = max(
                    (prices[idx] + helper(idx+2, 1, prices, dp)), (helper(idx+1, 0, prices, dp))
                )
            
            dp[idx][b] = profit
            return dp[idx][b]
        
        r,c = len(prices), 2
        dp = [[-1]*c for _ in range(r)] #initially the matrix will be filled with -1

        max_profit = helper(0,1,prices,dp)
        return max_profit
