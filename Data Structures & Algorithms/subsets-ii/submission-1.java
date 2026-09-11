class Solution {
    
    private void helper(int idx, List<Integer> subset, List<List<Integer>> ansList, int[] nums){ //ansList.add(new ArrayList<>(temp));
        // if(idx == nums.length){
            // List<Integer> temp = new ArrayList<>(subset);
            // // Collections.sort(temp);
            // if(!set.contains(temp)){
            //     ansList.add(new ArrayList<>(temp));
            //     set.add(temp);
            // }   
            // return;
        // }

        ansList.add(new ArrayList<>(subset));

        for(int j = idx; j<nums.length; j++){
            if(j > idx && nums[j] == nums[j - 1]){
                continue;
            }
            subset.add(nums[j]);
            helper(j + 1, subset, ansList, nums);
            subset.remove(subset.size() - 1);
        }
        // subset.add(nums[idx]);
        // helper(idx + 1, subset, ansList, nums, set);
        // subset.remove(subset.size() - 1);
        // helper(idx + 1, subset, ansList, nums, set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,new ArrayList<>(), ansList, nums);
        return ansList;
    }

}
