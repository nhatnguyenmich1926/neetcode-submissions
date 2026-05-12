import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minstack;
    public MinStack() {
        st = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if (minstack.isEmpty() || val <= minstack.peek()){
            minstack.push(val);
        }
    }
    
    public void pop() {
        if (minstack.peek().equals(st.peek())){
            minstack.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}