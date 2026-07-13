class MinStack {
    Stack<Integer> stk;
    public MinStack() {
        stk = new Stack<>();
        
    }
    
    public void push(int val) {
        stk.push(val);
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        Stack<Integer> mystk = new Stack<>();
        int min = stk.peek();
        while(!stk.isEmpty()){
            int curMin = stk.pop();
            mystk.push(curMin);
            min = Math.min(curMin, min);
        }

        while(!mystk.isEmpty()){
            stk.push(mystk.pop());
        }
        return min;
    }
}
