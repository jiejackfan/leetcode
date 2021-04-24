// April 23, 2021
class MinStack {
    // Aproach 1: using built-in stack
    // O(1), O(n)
    // The question wants O(1) time operation, the trick is to get getMin() function
    // in constant time as well.
    /** initialize your data structure here. */
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }
        int currMin = stack.peek()[1];
        stack.push(new int[]{val, Math.min(val, currMin)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
    
    // Approach 3: 2 stack 
    // O(1) O(n)
    Stack<Integer> stack;
    Stack<int[]> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        if (min.isEmpty() || val < min.peek()[0]) {
            min.push(new int[]{val, 1});
        }
        else if (val == min.peek()[0]){
            min.peek()[1]++;
        }
    }
    
    public void pop() {
        int deleted = stack.peek();
        stack.pop();
        if (deleted == min.peek()[0]) {
            if (min.peek()[1] == 1){
                min.pop();
            } else {
                min.peek()[1]--;
            }
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek()[0];
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