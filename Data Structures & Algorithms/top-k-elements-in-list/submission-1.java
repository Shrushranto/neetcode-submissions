class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqCounter = new HashMap<>();
        for(int i:nums){
            freqCounter.put(i,freqCounter.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->freqCounter.get(a)-freqCounter.get(b));
        for(int key : freqCounter.keySet()){
            minHeap.offer(key);

            if(minHeap.size() > k){
                minHeap.remove();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll();
        }

        return result;
    }
}
