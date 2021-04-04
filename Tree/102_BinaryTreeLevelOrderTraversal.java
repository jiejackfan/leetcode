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
    // DFS pre-order 
    // O(n), O(n)
    // Helper function keeps track of the level, and adds node to any level it wants.
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    public void helper(TreeNode node, int level) {
        // add this node to current level
        // if the current level exceeds the size of levels list
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        
        // process the children of this node using recursion
        if (node.left != null)
            helper(node.left, level+1);
        if (node.right != null) 
            helper(node.right, level+1);
        
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
    
    // BFS traversal, put all the nodes in a level at once.
    // O(n), O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int level = 0;
        while(!queue.isEmpty()) {
            // add new level
            levels.add(new ArrayList<Integer>());
            
            int length = queue.size();
            // add all nodes from current level into levels list
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            level++;
        }
        return levels;
    }
}