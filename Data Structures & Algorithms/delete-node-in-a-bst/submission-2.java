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
    public int height(TreeNode p){
        if (p == null) return 0;
        int x = height(p.left);
        int y = height(p.right);

        return Math.max(x,y) + 1;
    }
    public TreeNode inorder_predeccessor(TreeNode p){
        while (p != null && p.right != null) p = p.right;
        return p;
    }
    public TreeNode inorder_successor(TreeNode p){
        while (p != null && p.left != null) p = p.left;
        return p;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        // Empty tree
        if (root == null) return null;

        // Leaf Node 
        if (root.left == null && root.right == null){
            if (root.val == key) return null;
            return root;
        }

        if ( key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else{
            if (height(root.left) > height(root.right)){
                TreeNode current = inorder_predeccessor(root.left);
                root.val = current.val;
                root.left = deleteNode(root.left, current.val);
            }
            else{
                TreeNode current = inorder_successor(root.right);
                root.val = current.val;
                root.right = deleteNode(root.right, current.val); 
            }
        }
        return root;
    }
}