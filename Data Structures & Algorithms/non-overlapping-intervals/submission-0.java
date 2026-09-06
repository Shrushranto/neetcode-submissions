class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));

        int countOverlappingIntervals = 0;
        int[] prev = intervals[0];

        for(int i=1; i<intervals.length; i++){
            int curr[] = intervals[i];

            if(curr[0] < prev[1]){
                countOverlappingIntervals += 1;
            }else{
                prev = curr;
            }
        }
        return countOverlappingIntervals;
    }
}
