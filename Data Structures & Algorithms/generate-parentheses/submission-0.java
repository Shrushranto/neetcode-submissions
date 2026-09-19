class Solution {
    private void helper(int openPara, int closedPara, int n, List<String> ans, StringBuilder curans){
        
        if(openPara == closedPara && openPara == n){
            ans.add(curans.toString());
            return;
        }
        
        // first build openPara
        if(openPara < n){
            curans.append('(');
            helper(openPara + 1, closedPara, n, ans, curans);
            curans.deleteCharAt(curans.length() - 1);
        }

        if(closedPara < openPara){
            curans.append(")");
            helper(openPara, closedPara + 1, n, ans, curans);
            curans.deleteCharAt(curans.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0,0,n,ans, sb);
        return ans;
    }
}
