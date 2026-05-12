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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while(current != null || !st.isEmpty()){
            if (current != null){
                result.add(current.val);
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                current = current.right;
            }
        }
        return result;
    }
}