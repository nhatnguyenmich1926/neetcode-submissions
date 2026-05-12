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
       Stack<TreeNode> st = new Stack<>();
       TreeNode lastVisited = null;
       TreeNode current = root;

       while (current != null || !st.isEmpty()){
        if(current != null){
            st.push(current);
            current = current.left;
        }
        else{
            TreeNode peekNode = st.peek();
            if (peekNode.right != null && peekNode.right != lastVisited) current = peekNode.right;
            else {
                result.add(peekNode.val);
                lastVisited = st.pop();
            }
        }
       }
       return result;
    }
}