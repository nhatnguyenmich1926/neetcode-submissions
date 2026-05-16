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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null){
            lastVisited = current;
            if (val == current.val) return root;
            if (val < current.val) current = current.left;
            else current = current.right;
        }

        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;
        if (val < lastVisited.val) lastVisited.left = newNode;
        else lastVisited.right = newNode;

        return root;
    }
}