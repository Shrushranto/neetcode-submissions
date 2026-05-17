class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int need = target - nums[i];
            if(mp.containsKey(need)){
                int x=0;
                int y=0;
                if(i < mp.get(need)){
                    x = i;
                    y = mp.get(need);
                }else{
                    x = mp.get(need);
                    y = i;
                }
                return new int[] {x,y};
            }
            mp.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
