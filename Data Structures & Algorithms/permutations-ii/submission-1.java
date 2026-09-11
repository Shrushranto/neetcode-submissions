// class Solution {
//     private void getPermu(int idx, List<List<Integer>> ansList, int[] nums, HashSet<List<Integer>> set){
//         if(idx == nums.length){
//             List<Integer> perm = new ArrayList<>();
//             for(int i=0; i<nums.length; i++){
//                 perm.add(nums[i]);
//             }
//             if(!set.contains(perm)){
//                 ansList.add(new ArrayList<>(perm));
//                 set.add(perm);
//             }
//             return;
//         }

//         for(int i=idx; i<nums.length; i++){
//             swap(idx, i, nums);
//             getPermu(idx+1, ansList, nums, set);
//             swap(idx, i, nums);
//         }
//     }
//     private void swap(int i, int j, int[] nums){
//         int t = nums[i];
//         nums[i] = nums[j];
//         nums[j] = t;
//     }
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> ansList = new ArrayList<>();
//         Arrays.sort(nums);
//         getPermu(0, ansList, nums, new HashSet<>());
//         return ansList;
//     }
// }


class Solution {

    private void getPermu(int idx, List<List<Integer>> ansList, int[] nums) {

        if(idx == nums.length) {
            List<Integer> perm = new ArrayList<>();

            for(int num : nums) {
                perm.add(num);
            }

            ansList.add(perm);
            return;
        }

        HashSet<Integer> used = new HashSet<>();

        for(int i = idx; i < nums.length; i++) {

            if(used.contains(nums[i])) {
                continue;
            }

            used.add(nums[i]);

            swap(idx, i, nums);

            getPermu(idx + 1, ansList, nums);

            swap(idx, i, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();

        getPermu(0, ansList, nums);

        return ansList;
    }
}