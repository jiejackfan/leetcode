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
    // Approach: labuladong
    // post order traversal, no need helper because we only manipulate on one node
    // O(n) go through every element
    // O(n) recursion stack
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        
        flatten(root.left);
        flatten(root.right);
        
        // post order here process the root
        // left and right already flattened
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        // just move left to right and right to bottom of left
        root.right = left;
        root.left = null;
        
        TreeNode p = root;
        while (p.right != null)
            p = p.right;
        
        p.right = right;
    }
}