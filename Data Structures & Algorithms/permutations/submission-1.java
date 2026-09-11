class Solution {

    private void getPermutation(List<Integer> perm, List<List<Integer>> ansList, boolean[] freq, int[] nums){
        if(perm.size() == nums.length){
            ansList.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                perm.add(nums[i]);
                freq[i] = true;
                getPermutation(perm, ansList, freq, nums);
                perm.remove(perm.size() - 1);
                freq[i] = false;
                // getPermutation(perm, ansList, freq, nums);
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        boolean[] freqCounter = new boolean[nums.length];

        getPermutation(new ArrayList<>(), ansList, freqCounter, nums);
        return ansList;
    }
}
