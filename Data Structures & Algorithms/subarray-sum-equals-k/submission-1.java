class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,1); // subarray with sum 0 has 1 count.

        int count = 0;
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int need = prefixSum - k;

            if(mpp.containsKey(need)){
                count += mpp.get(need);
            }
            mpp.put(prefixSum, mpp.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}