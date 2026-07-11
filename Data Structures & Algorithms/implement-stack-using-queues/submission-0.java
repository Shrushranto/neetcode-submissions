class MyStack {
    Queue<Integer> myQ;
    public MyStack() {
        myQ = new LinkedList<>();
    }

    public void push(int x) {
        myQ.offer(x);
        for (int i = myQ.size() - 1; i > 0; i--) {
            myQ.offer(myQ.poll());
        }
    }

    public int pop() {
        return myQ.poll();
    }

    public int top() {
        return myQ.peek();
    }

    public boolean empty() {
        return myQ.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */