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
    
    // Approach 1: DFS recursion
    // Recursion DFS. Find the best path for child first and add up at the end.
    // There is a possibility where adding path has smaller sum than 2children plus current node, so we consider that poissibility within the recursion.
    // O(n)
    // O(height) recursion stack
    int max_sum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
    
    // helper
    private int max_gain(TreeNode node) {
        // base case: return if at leaf
        if (node == null) return 0;
        
        // calculate max sum of left and right subtree using recursion
        // A possibility is the max gain is negative, therefore choose between 0 and left.
        int left = Math.max(max_gain(node.left), 0);
        int right = Math.max(max_gain(node.right), 0);
        
        // calculate the sum of a new path from this node (node itself and its 2 children)
        int price_newpath = node.val + left + right;
        
        // update max sum if new path has the highest sum
        max_sum = Math.max(price_newpath, max_sum);
        
        // continue the old path from the last level, return the node and the max child
        return node.val + Math.max(left, right);
    }
}