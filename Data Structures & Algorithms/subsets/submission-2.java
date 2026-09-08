class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        // List<Integer> subset = new ArrayList<>();
        // helper(0, ansList,subset, nums, nums.length );
        helper(0, ansList,new ArrayList<>(), nums, nums.length );
        return ansList;
    }
    private void helper(int idx,List<List<Integer>> ansList, List<Integer> subset, int[] nums, int n){
        if(idx == n){
            ansList.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        helper(idx+1,ansList, subset, nums, n);
        subset.remove(subset.size()-1);
        helper(idx+1, ansList, subset, nums, n);
    }
}
