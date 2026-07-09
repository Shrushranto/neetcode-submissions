class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);

        while(r<nums.length){
            maxHeap.offer(new int[]{nums[r], r});
            if(r-l+1 == k){
                ans.add(maxHeap.peek()[0]);
                l++;
            }

            while(!maxHeap.isEmpty() && maxHeap.peek()[1] < l){
                maxHeap.poll();
            }
            r++;
        }
        int[] ansArr = new int[ans.size()];
        for(int i=0; i<ansArr.length; i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}
