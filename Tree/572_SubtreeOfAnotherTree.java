// 07/01/2021
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
    // Recursive DFS
    // O(n^2)
    // O(logn) recursive stack
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if root is null, then we return false
        if (root == null) return false;
        
        // check if they are identical at this level
        if (isSame(root, subRoot)) return true;
        
        // check next levels
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    
    // helper to find 
    private boolean isSame(TreeNode s, TreeNode t) {
        // base case
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        // check if the remaining tree is also similar
        return (s.val == t.val) && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}