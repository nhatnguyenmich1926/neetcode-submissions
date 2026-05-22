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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean seenNull = false;

        while (!q.isEmpty()){
            TreeNode current = q.poll();

            if (current == null) seenNull = true;
            else{
                if (seenNull) return false;

                q.offer(current.left);
                q.offer(current.right);
            }
        }
        return true;
    }
}