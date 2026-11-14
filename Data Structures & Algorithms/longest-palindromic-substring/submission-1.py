class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = "" #result string, answer
        resLen = 0 #current lenght of the string

        for i in range(len(s)):
            # for odd length palindrome
            l,r = i,i
            while l>=0 and r<len(s) and s[l] == s[r]:
                if r-l+1 > resLen:
                    resLen = r-l+1
                    res = s[l:r+1]
                l -= 1
                r += 1
            

            # for even length palindrome
            l,r = i, i+1
            while l >= 0 and r < len(s) and s[l] == s[r]:
                if r-l+1 > resLen:
                    resLen = r-l+1
                    res = s[l:r+1]
                l -= 1
                r += 1
        
        return res