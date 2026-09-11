class Solution {
    
    private void helper(int idx, List<Integer> subset, List<List<Integer>> ansList, int[] nums, HashSet<List> set){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>(subset);
            Collections.sort(temp);
            if(!set.contains(temp)){
                ansList.add(new ArrayList<>(temp));
                set.add(temp);
            }   
            return;
        }
        subset.add(nums[idx]);
        helper(idx + 1, subset, ansList, nums, set);
        subset.remove(subset.size() - 1);
        helper(idx + 1, subset, ansList, nums, set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        // Arrays.sort(nums);
        helper(0,new ArrayList<>(), ansList, nums, new HashSet<>());
        return ansList;
    }

}
