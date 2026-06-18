class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i:nums){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int times = (int)Math.floor(nums.length / 3);
        List<Integer> ans = new ArrayList<>();
        for(int k : mp.keySet()){
            if(mp.get(k) > times){
                ans.add(k);
            }
        }

        return ans;
    }
}