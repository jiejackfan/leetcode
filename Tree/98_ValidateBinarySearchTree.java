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
    
    
//     // Recursion DFS pre-order:
//     // O(n) go through each node once, O(n) keep up entire tree during recursion
    public boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        //check if the value of this current node is in between the limits given
        if ( (low != null && low >= node.val) || (high != null && high <= node.val)) {
            return false;
        }
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
    
    // 
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    

}