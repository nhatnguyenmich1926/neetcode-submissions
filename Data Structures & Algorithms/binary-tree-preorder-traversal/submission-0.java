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
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode t = root;
        while (t != null || !st.isEmpty()){
            if (t != null){
                result.add(t.val);
                st.push(t);
                t = t.left;
            }
            else {
                t = st.pop();
                t = t.right;
            }
        }
        return result;
    }
}