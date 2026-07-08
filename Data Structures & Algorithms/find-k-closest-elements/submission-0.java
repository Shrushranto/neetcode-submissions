class Solution {
    class Pair {
        int n1;
        int n2;
        Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            int diff = Math.abs(x - b.n1) - (Math.abs(x - a.n1));
            if (diff == 0) {
                return b.n1 - a.n1;
            }
            return diff;
        });

        for(int i:arr){
            maxHeap.offer(new Pair(i,i));
            if(maxHeap.size() >k){
                maxHeap.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            int val = maxHeap.peek().n2;
            ans.add(val);
            maxHeap.remove();
        }

        Collections.sort(ans);
        return ans;
    }
}