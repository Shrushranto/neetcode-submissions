class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False
        
        s1 = sorted(s)
        s2 = sorted(t)

        for i in range(len(s1)):
            if(s1[i] != s2[i]):
                return False
        
        return True