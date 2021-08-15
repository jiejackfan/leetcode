// 8/15/2021
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
    
    // Approach 1: DFS Top Down Recursion
    // O(nlogn) n for finding height of each logn tree recursion
    // O(n) recursion stack
    public boolean isBalanced(TreeNode root) {
        // base case : if we reach null node, we return true
        if (root == null) 
            return true;
        
        // check current level children height difference and check if subtrees are balanced
        return Math.abs(height(root.left) - height(root.right)) <= 1 
            && isBalanced(root.left)
            && isBalanced(root.right);
    } 
    
    // helper to find height of current node
    private int height(TreeNode node) {
        // base case: reach end of node, set starting point of height as -1
        if (node == null) 
            return -1;
        
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    
    // Approach 2: DFS Bottom Up
    // Calculate height of children nodes first so we don't have to duplicate calculate height
    // O(n) each node compute height and compare in constant time
    // O(n) recursion stack of unbalanced tree worst case
    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }
    
    //helper: return tree height and balanced? of root in a ref var
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        // base case: 
        if (root == null)
            return new TreeInfo(-1, true);
        
        // check subtree if they are balanced
        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) 
            return new TreeInfo(-1, false);
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced)
            return new TreeInfo(-1, false);
        
        // use height obtained above to determine if current node is balanced
        if (Math.abs(left.height - right.height) <= 1)
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        
        return new TreeInfo(-1, false);
    }
}

// for approach 2:
public class TreeInfo {
    public final int height;
    public final boolean balanced;
    
    public TreeInfo(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}