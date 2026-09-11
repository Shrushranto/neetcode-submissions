class Solution {
    private void getPermu(int idx, List<List<Integer>> ansList, int[] nums, HashSet<List<Integer>> set){
        if(idx == nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                perm.add(nums[i]);
            }
            if(!set.contains(perm)){
                ansList.add(new ArrayList<>(perm));
                set.add(perm);
            }
            return;
        }

        for(int i=idx; i<nums.length; i++){
            swap(idx, i, nums);
            getPermu(idx+1, ansList, nums, set);
            swap(idx, i, nums);
        }
    }
    private void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);
        getPermu(0, ansList, nums, new HashSet<>());
        return ansList;
    }
}