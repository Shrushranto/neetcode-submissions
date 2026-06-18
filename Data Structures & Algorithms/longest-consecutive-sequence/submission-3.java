class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        if(nums.length < 1) return 0;

        int maxSeq = 0;

        for(int n : nums){
            if(!set.contains(n-1)){
                int curNum = n;
                int curSeqLen = 1;
                while(set.contains(curNum + 1)){
                    curSeqLen += 1;
                    curNum++;
                }

                maxSeq = Math.max(curSeqLen, maxSeq);
            }
        }

        return maxSeq;
    }
}
