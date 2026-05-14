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
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if (subRoot == null) return true;
        if (root == null) return false;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        TreeNode current = root;
        while (!st.isEmpty()){
            current = st.pop();
            if (current.val == subRoot.val){
                if (isSameTree(current, subRoot)) return true;
            }

            if (current.right != null) st.push(current.right);
            if (current.left != null) st.push(current.left);
        }
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> st = new Stack<>();
        st.push(new TreeNode[]{p, q});
        while (!st.isEmpty()){
            TreeNode[] nodes = st.pop();
            TreeNode node1 = nodes[0], node2 = nodes[1];

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;
            st.push(new TreeNode[]{node1.right,node2.right});
            st.push(new TreeNode[]{node1.left, node2.left});
        }
        return true;
    }
}
