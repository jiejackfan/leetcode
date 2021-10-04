// 10/4/2021

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
    // Approach 1: DFS 
    // Longest path can be either the left subtree, right subtree or left+right subtree
    private int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    
    private int longestPath(TreeNode node) {
        // base case: node == null
        if (node == null)
            return 0;
        
        // post order: find left and right length first;
        int left = longestPath(node.left);
        int right = longestPath(node.right);
        diameter = Math.max(diameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}