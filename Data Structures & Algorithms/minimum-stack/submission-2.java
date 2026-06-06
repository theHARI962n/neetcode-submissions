class MinStack {

    Stack<Integer> st ;
    Stack<Integer> minStack;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty() || val <=minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
       int removed = st.pop();
        if(removed == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
       return st.peek();
    }
    
    public int getMin() {
        
       return minStack.peek();
    }
}
