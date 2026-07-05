class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                if(isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1)){
                    return true;
                }else{
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean isPalindrome(String s, int st, int e){
        int lft = st;
        int rt  = e;
        while(lft < rt){
            if(s.charAt(lft) != s.charAt(rt)){
                return false;
            }
            lft++;
            rt--;
        }

        return true;
    }
}