class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for (String op: operations){
            if (op.equals("C")){
                st.pop();
            }
            else if (op.equals("D")){
                st.push(st.peek() * 2);
            }
            else if (op.equals("+")){
                int top = st.pop();
                int newTop = top + st.peek();
                st.push(top); // Push back
                st.push(newTop);
            }
            else{
                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int x : st){
            sum += x;
        }
        return sum;
    }
}