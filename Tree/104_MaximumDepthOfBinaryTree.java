// April 3 2021
// tag: Tree

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
    // // Simple recursion post-order DFS
    // // O(n), O(logn)
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) +1;
        }
    }

    // April 26 update
    // Top down: preorder traversal
    // Need global variable to keep track. Calculate current node level first and feed down into the children.
    private int maxAns = 1;
    public int maxDepth(TreeNode root) {
        traverse(root, maxAns);
        return maxAns;
    }
    private void traverse(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) 
            maxAns = Math.max(maxAns, depth);
        traverse(root.left, depth+1);
        traverse(root.right, depth+1);
        return;
    }
    
    // Bottom up: postorder traversal
    // Use children to return to parent node.
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        return Math.max(ldepth, rdepth) + 1;
    }


}