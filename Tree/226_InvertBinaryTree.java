// 6/29/2021

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
    // O(n) every node visited once
    // O(n) worst case recursion stack
    public TreeNode invertTree(TreeNode root) {
        // base case to stop recursion
        if (root == null) return null;
        
        // invert left and right nodes using recursion
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // criss-cross
        root.left = right;
        root.right = left;
        return root;
   }
    
    // Approach 2: BFS iterative
    // use a queue to act as recursion stack. Continuously add queue front's left and right node within queue
    // O(n) 
    // O(n) queue size
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        // setup queue for iteration
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            // get the current node from the queue
            TreeNode curr = queue.poll();
            // swap the left and right children of the current node
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            
            // add left and right children into the queue only if they are not null
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return root;
    }
} 