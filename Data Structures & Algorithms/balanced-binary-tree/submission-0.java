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
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode current = root;
        HashMap<TreeNode, Integer> map = new HashMap<>();

        while (current != null || !st.isEmpty()){
            if (current != null){
                st.push(current);
                current = current.left;
            }
            else {
                TreeNode peekNode = st.peek();
                if (peekNode.right != null && lastVisited != peekNode.right){
                    current = peekNode.right;
                } else{
                    lastVisited = st.pop();
                    int leftHeight = 0;
                    int rightHeight = 0;

                    if (peekNode.right != null) rightHeight = map.get(peekNode.right);
                    if (peekNode.left != null) leftHeight = map.get(peekNode.left);

                    if (Math.abs(leftHeight - rightHeight) > 1) return false;

                    int currentHeight = Math.max(leftHeight, rightHeight) + 1;
                    map.put(lastVisited, currentHeight);
                }
            }
        }
        return true;
    }
}
