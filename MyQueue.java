class MyQueue {
    
    // queue is implemented considering two stacks
    // in stack is used completely to push elements
    // out stack is used to implement peek and pop
    
    private Stack<Integer> in;
    private Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    // O(1) time complexity
    public void push(int x) {
        in.push(x);
        
    }
    
    // O(1) amortized time complexity but O(n) for worst case
    // elements are passed to another stack only if out stack is empty
    // 
    public int pop() {
        peek();
        return out.pop();
    }
    
    // O(n) time complexity
    // 
    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    // O(1) time complexity
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    // the space complexity is O(n)     
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
