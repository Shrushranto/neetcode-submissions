class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stk = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            while(!stk.isEmpty() && temperatures[i] > stk.peek()[0]){
                res[stk.peek()[1]] = i - stk.peek()[1];
                stk.pop();
            }
            stk.push(new int[]{temperatures[i], i});
        }   

        while(!stk.isEmpty()){
            res[stk.peek()[1]] = 0;
            stk.pop();
        }
        return res;
    }
}
