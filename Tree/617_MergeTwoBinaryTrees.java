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
    // Approach 1 : DFS
    // Use root1 as the base tree to start building the merge tree
    // preorder traversal
    // O(n) n=number of nodes in both trees
    // O(n) recursion stack 
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // use current tree as the new node
        if (root1 == null)
            return root2;
        else if (root2 == null)
            return root1;
        
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
    }
}