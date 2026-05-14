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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        int value = 0;

        if (root1 != null) value += root1.val;
        if (root2 != null) value += root2.val;

        TreeNode mergedRoot = new TreeNode(value);

        Stack<TreeNode[]> st = new Stack<>();
        st.push(new TreeNode[]{root1, root2, mergedRoot});

        while (!st.isEmpty()){
            TreeNode[] nodes = st.pop();

            TreeNode node1 = nodes[0], node2 = nodes[1], merged = nodes[2];

            // LEFt
            TreeNode left1 = null;
            TreeNode left2 = null;

            if (node1 != null) left1 = node1.left;
            if (node2 != null) left2 = node2.left;

            if (left1 != null || left2 != null){
                int leftValue = 0;
                if (left1 != null) leftValue += left1.val;
                if (left2 != null) leftValue += left2.val;

                merged.left = new TreeNode(leftValue);

                st.push(new TreeNode[]{left1, left2, merged.left});
            }

            // Right
            TreeNode right1 = null;
            TreeNode right2 = null;

            if (node1 != null) right1 = node1.right;
            if (node2 != null) right2 = node2.right;

            if (right1 != null || right2 != null){
                int rightValue = 0;
                if (right1 != null) rightValue += right1.val;
                if (right2 != null) rightValue += right2.val;

                merged.right = new TreeNode(rightValue);
                st.push(new TreeNode[]{right1, right2, merged.right});
            }
        }
        return mergedRoot;
    }
}