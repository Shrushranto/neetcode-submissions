class Solution {

    // private void getPermutation(List<Integer> perm, List<List<Integer>> ansList, boolean[] freq, int[] nums){
    //     if(perm.size() == nums.length){
    //         ansList.add(new ArrayList<>(perm));
    //         return;
    //     }

    //     for(int i=0; i<nums.length; i++){
    //         if(!freq[i]){
    //             perm.add(nums[i]);
    //             freq[i] = true;
    //             getPermutation(perm, ansList, freq, nums);
    //             perm.remove(perm.size() - 1);
    //             freq[i] = false;
    //             // getPermutation(perm, ansList, freq, nums);
    //         }
    //     }
    // }


    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> ansList = new ArrayList<>();
    //     boolean[] freqCounter = new boolean[nums.length];

    //     getPermutation(new ArrayList<>(), ansList, freqCounter, nums);
    //     return ansList;
    // }

    private void getPermu(int idx, List<List<Integer>> ansList, int[] nums){
        if(idx > nums.length-1){
            List<Integer> perm = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                perm.add(nums[i]);
            }
            ansList.add(new ArrayList<>(perm));
            return;
        }

        for(int j = idx; j < nums.length; j++){
            swap(idx, j, nums);
            getPermu(idx+1, ansList, nums);
            swap(idx, j, nums);
        }
    }

    private void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // in this approach im swapping the values of nums inplace and while backtracking im changing the changes made for next tree
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        // List<Integer> perm = new ArrayList<>();

        getPermu(0, ansList, nums);
        return ansList;
    }

    
}
