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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        TreeNode previous = null;

        while (current != null || !st.isEmpty()){
            while (current != null){
                st.push(current);
                current = current.left;
            }

            current = st.pop();

            if (previous != null && previous.val >= current.val) return false;

            previous = current;
            current = current.right;
        }
        return true;
    }
}
