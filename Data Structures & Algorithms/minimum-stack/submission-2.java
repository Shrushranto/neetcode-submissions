class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;
    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(minStk.isEmpty() || val <= minStk.peek()){
            minStk.push(val);
        }
    }
    
    public void pop() {
        if(stk.isEmpty()) return;
        int top = stk.pop();
        if(minStk.peek() == top){
            minStk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}
