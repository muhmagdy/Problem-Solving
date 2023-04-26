import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minimum;

    public MinStack() {
        stack = new Stack<>();
        minimum = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minimum.isEmpty() || minimum.peek() >= val)
            minimum.push(val);
    }
    
    public void pop() {        
        if(minimum.peek().equals(stack.peek()))
            minimum.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimum.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */