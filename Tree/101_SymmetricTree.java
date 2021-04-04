// April 2 2021
// tag: Tree, DFS, BFS

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
    // Logic: Check if two same tree's left and right subtree are mirror of each other.

    // Recursive DFS: O(n), O(n)
    // Build helper function called isMirror and compare 2 of the same tree. Check if current node has the same
    // value and recur on isMirror to see if tree1.left == tree2.right and tree1.right == tree2.left.
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        
        return (t1.val == t2.val) 
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
    

    // Iterative BFS: O(n), O(n)
    // Start queue with 2 root. Analyze 2 nodes at a time, if their value is the same, we continue to add more sub-tree
    // to the node. When adding subtree, add tree1's left and tree2's right to compare to see if they are mirror.
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
        
    }
}