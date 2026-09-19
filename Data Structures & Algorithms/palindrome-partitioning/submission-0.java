class Solution {
    private void getPartition(int idx,String s, List<List<String>> ansList, List<String> curList){
        if(idx == s.length()){
            ansList.add(new ArrayList<>(curList));
            return;
        }    
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s,idx,i)){
                curList.add(s.substring(idx, i+1));
                getPartition(i+1, s, ansList, curList);
                curList.remove(curList.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,  int l, int r){
        while(l<=r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ansList = new ArrayList<>();
        getPartition(0,s, ansList, new ArrayList<>());
        return ansList;
    }
}
