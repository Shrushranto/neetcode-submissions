class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(!maxHeap.isEmpty()){ // until the heap is empty we will continue our simulation
            if(maxHeap.size() == 1){
                break;
            }
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();

            if(firstStone == secondStone){
                continue;
            }
            
            if(secondStone < firstStone){
                secondStone = firstStone - secondStone;
                maxHeap.offer(secondStone);
            }
        }

        if(maxHeap.isEmpty()){
            return 0;
        }

        return maxHeap.peek();
    }
}
