class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int res = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int sum = prefixSum - k;
            if(mpp.containsKey(sum)){
                res += mpp.get(sum);
            }
            mpp.put(prefixSum, mpp.getOrDefault(prefixSum, 0) + 1);
        }

        return res;
    }
}