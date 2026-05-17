class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<strs[0].length(); i++){
            for(int s=0; s<strs.length; s++){
                if(i == strs[s].length() || strs[s].charAt(i) != strs[0].charAt(i)){
                    return ans.toString();
                }
            }
            ans.append(strs[0].charAt(i));
        }
        return ans.toString();
    }
}