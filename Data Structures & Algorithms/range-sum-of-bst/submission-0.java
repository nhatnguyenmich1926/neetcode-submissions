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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> st = new Stack<>();
        int res = 0;
        st.push(root);
        while (!st.isEmpty()){
            TreeNode current = st.pop();
            if (current == null) continue;
            if (low <= current.val && current.val <= high) res += current.val;

            if (current.val > low) st.push(current.left);
            if (current.val < high) st.push(current.right);
        }
        return res;
    }
}