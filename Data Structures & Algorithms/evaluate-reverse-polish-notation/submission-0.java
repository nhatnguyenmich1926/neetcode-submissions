class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++){
            String token = tokens[i];

            if (!isOperator(token)){
                st.push(Integer.parseInt(token));
            }
            else{
                int b = st.pop();
                int a = st.pop();
                if (token.equals("+")) st.push(a + b);
                else if (token.equals("-")) st.push(a - b);
                else if (token.equals("*")) st.push(a * b);
                else if (token.equals("/")) st.push(a / b);
            }
        }
        return st.pop();
    }
    public boolean isOperator (String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
