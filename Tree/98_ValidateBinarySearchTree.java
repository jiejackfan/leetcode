// April 3, 2021
// tag: tree, recursion, DFS

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
    // binary search tree, the nodes in subtree can't be equal to its parent node.
    // All nodes in left subtree are smaller, all nodes in right subtree are larger
    
    
    // recursion DFS
    // binary search trees property: left subtree values are smaller than root, right subtree values are larger than root
    // O(n) once thru every element
    // O(logn) recursion stack 
    public boolean isValidBST(TreeNode root) {
        return recur(root, null, null);
    }
    
    // recursion helper sets up lower/upper bound for entire subtree
    // slowly this will develop into a range limit for each node
    private boolean recur(TreeNode node, Integer low, Integer high) {
        // base case
        if (node == null) return true;
        
        // check if current section of tree is valid BST
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }
        
        // recur on children elements
        return recur(node.left, low, node.val) && recur(node.right, node.val, high);
    }

}