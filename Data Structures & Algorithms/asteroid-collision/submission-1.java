class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i : asteroids){
            while(!stk.isEmpty() && i<0 && stk.peek() > 0){
                if(Math.abs(i) == stk.peek()){
                    i=0;
                    stk.pop();
                }else if(Math.abs(i) > stk.peek()){
                    stk.pop();
                }else {
                    i=0;
                }
            }
            if(i != 0){
                stk.push(i);
            }
        }
        return stk.stream().mapToInt(i -> i).toArray();

    }
}