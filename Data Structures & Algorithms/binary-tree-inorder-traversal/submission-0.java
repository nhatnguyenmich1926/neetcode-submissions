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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode t = root;
        Stack<TreeNode> st = new Stack<>();
        while(t != null || !st.isEmpty()){
            if (t != null){
                st.push(t);
                t = t.left;
            }
            else {
                t = st.pop();
                result.add(t.val);
                t = t.right;
            }
        }
        return result;
    }
}