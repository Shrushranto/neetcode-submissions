class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)->Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));

        int curCapacity = 0;

        for(int[] trip : trips){
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            while(!minHeap.isEmpty() && minHeap.peek()[2] <= start){
                int[] finishedTrip = minHeap.poll();
                curCapacity -= finishedTrip[0];
            }

            curCapacity += passengers;
            if(curCapacity > capacity){
                return false;
            }

            minHeap.add(trip);
        }
        return true;
        
        
    }
}