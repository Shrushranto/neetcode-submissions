class Solution {
    List<String> res = new ArrayList<>();
    String[] charArr = new String[]{
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    private void helper(int idx, StringBuilder ans, String digi){
        if(ans.length() >= digi.length()){
            res.add(new String(ans));
            return;
        }

        String curData = charArr[digi.charAt(idx) - '0']; // this will basically contain charArr[3] which is def;
        for(char c : curData.toCharArray()){
            ans.append(c);
            helper(idx + 1, ans, digi);
            ans.deleteCharAt(ans.length() - 1);
        }
        // return;
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() < 1){
            return res;
        }
        helper(0, new StringBuilder(), digits);
        return res;  
    }
}
