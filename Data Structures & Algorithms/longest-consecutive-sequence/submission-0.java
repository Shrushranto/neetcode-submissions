class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int cnt = 0;

        for(int i =0; i<nums.length; i++){
            seen.add(nums[i]);
        }

        int startVal = 0;
        for(int i : nums){
            int curNum = i;
            while(seen.contains(curNum - 1)){
                curNum -= 1;
            }
            startVal = curNum;
            int curSeq = 0;
            while(seen.contains(startVal)){
                curSeq += 1;
                startVal += 1;
            }

            cnt = Math.max(cnt, curSeq);
        }
        return cnt;
    }
}
