/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        while (current != null || !st.isEmpty()){
            // Go as left as possible
            if (current != null){
                st.push(current);
                current = current.left;
            }
            else{
                TreeNode peekNode = st.peek();
                // If right child does exist and not processed yet
                if (peekNode.right != null && lastVisited != peekNode.right){
                    current = peekNode.right;
                }
                else {
                    result.add(peekNode.val);
                    lastVisited = st.pop();
                }
            }
            return result;
        }
    }
}