// may 13, 2021 recursion lesson 1

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
    
    // recursion 
    // O(height) average case logn, worst case n.
    // O(height) recursion stack.
    // binary search tree node is greater than its left subtree and is less than its right subtree
    // recur on child node 
    public TreeNode searchBST(TreeNode root, int val) {
        // base case 
        if (root == null || root.val == val) return root;
        
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
    
    // iteration:
    // O(height)
    // o(1)
    // same logic, use a while loop to go around the tree to find target node.
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}