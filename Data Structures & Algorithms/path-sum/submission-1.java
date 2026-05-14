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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> stSum = new Stack<>();
        st.push(root);
        stSum.push(targetSum - root.val);

        while (!st.isEmpty()){
            TreeNode current = st.pop();
            int currentSum = stSum.pop();

            if (current.left == null && current.right == null && currentSum == 0) return true;
            if (current.left != null){
                st.push(current.left);
                stSum.push(currentSum - current.left.val);
            }
            if (current.right != null){
                st.push(current.right);
                stSum.push(currentSum - current.right.val);
            }
        }
        return false;
    }
}