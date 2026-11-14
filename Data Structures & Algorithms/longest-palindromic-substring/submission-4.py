class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        resLen = 0
        ans = ""

        def checkPalindrome(l,r,s,dp):
            if(l>=r):
                return 1
            if(s[l] != s[r]):
                return 0
            
            if dp[l][r] != -1:
                return dp[l][r]
        
            # if s[l] == s[r]:
            #     check = checkPalindrome(l+1, r-1, s)
            
            dp[l][r] = checkPalindrome(l+1, r-1, s, dp)
            return dp[l][r]

        # memoization using 2d DP
        dp = [[-1 for j in range(n)]for i in range(n)]
       

        for l in range(n):
            for r in range(l,n):
                if checkPalindrome(l,r,s,dp):
                    if r-l+1 > resLen:
                        resLen = r-l+1
                        ans = s[l:r+1]
        
        return ans
        
