# total_profit = 0

        # for i in range(1,len(prices)):
        #     if(prices[i] > prices[i-1]):
        #         total_profit += prices[i] - prices[i-1]

        # return total_profit

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # lets do it using recursion and DP
        def helper(i,b,prices,dp):
            if(i==len(prices)):
                return 0

            if(dp[i][b] != -1):
                return dp[i][b]

            profit = 0
            if(b == 0):
                profit = max((-prices[i] + helper(i+1, 1, prices,dp)),(helper(i+1,0,prices,dp)))
            else:
                profit = max((prices[i] + helper(i+1, 0, prices,dp)), (helper(i+1, 1,prices,dp)))
            
            dp[i][b] = profit
            return dp[i][b] 
        

        r,c = len(prices),2
        dp = [[-1]*c for _ in range(r)]

        ans = helper(0,0,prices, dp)
        return ans
