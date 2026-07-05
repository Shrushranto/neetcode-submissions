class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l<=r){
            char left = s.charAt(l);
            char right = s.charAt(r);
            if(Character.isLetterOrDigit(left) && Character.isLetterOrDigit(right)){
                if(Character.toLowerCase(left) == Character.toLowerCase(right)){
                    l++;
                    r--;
                }else{
                    return false;
                }
            }else if(Character.isLetterOrDigit(left) && !Character.isLetterOrDigit(right)){
                r--;
            }else{
                l++;
            }
        }
        return true;

    }
}
