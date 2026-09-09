class Solution {
    List<List<Integer>> ansList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(1,new ArrayList<>(), n, k);
        return ansList;
    }
    private void helper(int i, List<Integer> set, int n, int k){
        if(set.size() == k){
            ansList.add(new ArrayList<>(set));
            return;
        }

        if(i>n){
            return;
        }

        set.add(i);
        helper(i+1,set, n, k);
        set.remove(set.size()-1);
        helper(i+1,set, n, k);
        
    }
}