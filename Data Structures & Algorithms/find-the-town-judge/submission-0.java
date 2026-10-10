class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];

        for(int [] person : trust){
            int[] arr = person;
            outDegree[arr[0]] += 1;
            inDegree[arr[1]] += 1;
        }

        for(int i = 1; i<= n; i++){
            if(outDegree[i] == 0 && inDegree[i] == n-1){
                return i;
            }
        }
        return -1;


    }
}