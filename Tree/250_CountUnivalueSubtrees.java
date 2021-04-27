// April 27, 2021

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
    // O(n) 
    // O(height)
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isUni(root);
        return count;
    }
    
    private boolean isUni(TreeNode root) {
        // base case if children are all null, then it is a uni-value subtree
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        
        // assume current node is uni value. Not top down approach because no calculation at curr node before children
        boolean isUniVal = true;
        
        if (root.left != null) {
            isUniVal = isUni(root.left) && isUniVal && root.left.val == root.val;
        }
        if (root.right != null) {
            isUniVal = isUni(root.right) && isUniVal && root.right.val == root.val;
        }
        
        // process current node
        if (!isUniVal) return false;
        else {
            count++;
            return true;
        }
    }
    
    // recursion with parent
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isUni(root, 0);
        return count;
    }
    private boolean isUni(TreeNode root, int prevVal) {
        if (root == null) return true;
        
        if (!isUni(root.left, root.val) | !isUni(root.right, root.val)) return false;
        
        count++;
        
        return root.val == prevVal;
    }
}