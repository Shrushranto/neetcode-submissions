class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        if(nums.length < 1){
            return 0;
        }
        for(int i: nums){
            seen.add(i);
        }

        int longestSeq = 0;

        for(int n : seen){
            int startOfSeq = 0;
            int curSeqLen = 0;

            if(!seen.contains(n - 1)){
                startOfSeq = n;
                while(seen.contains(startOfSeq+1)){
                    curSeqLen++;
                    startOfSeq++;
                }

                longestSeq = Math.max(curSeqLen, longestSeq);
            }else{
                continue;
            }
        }

        return longestSeq + 1;
    }
}
