class Solution {
    public String reorganizeString(String s) {
        int[] counter = new int[26];
        for(char c : s.toCharArray()){
            counter[c-'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));

        for(int i=0; i<26; i++){
            if(counter[i] > 0){
                maxHeap.add(new int[]{i, counter[i]});
            }
        }

        int prev[] = null;
        StringBuilder ans = new StringBuilder();

        while(!maxHeap.isEmpty()){

            int[] curr = maxHeap.poll();
            char c = (char)('a' + curr[0]);
            
            // using the curr character
            ans.append(c);
            curr[1]--;

            // pushing back the previous character back to the heap
            if(prev != null && prev[1] > 0){
                maxHeap.add(prev);
            }

            // current character becomes the previous character
            prev = curr;
        }

        if(ans.length() != s.length()){
            return "";
        }

        return ans.toString();
    }
}