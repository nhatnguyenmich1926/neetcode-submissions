
class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            // Pop all buildings that are blocked by current
            while (!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                st.pop();
            }

            st.push(i);
        }

        // Convert stack → result array
        int size = st.size();
        int[] res = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}