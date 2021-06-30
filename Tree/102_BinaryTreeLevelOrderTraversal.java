// April 2 2021
// 06/29/2021
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
    // Approach 1: DFS recursion
    // O(n)
    // O(n)
    // Pre-order traversal where we put current node in list first and put the children in list using recursion   
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return list;
    }
    
    // helper function used in recursion, this function will take in level var to know which list this node belongs in
    private void helper(TreeNode node, int level) {
        // base case to return from recursion
        if (node == null) return; 
        
        // need to add complete new level into the list
        if (list.size() == level)
            list.add(new ArrayList<Integer>());
        
        // fill current level
        list.get(level).add(node.val);
        
        // recur on the children nodes
        helper(node.left, level + 1);
        helper(node.right, level + 1);
        
        return;
    }
    
    // Approach 2: BFS Iterative
    // Build a queue, at the end of each while is a level. 
    public List<List<Integer>> levelOrder(TreeNode root) {
        // initialize data structure
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            // add new level to list
            list.add(new ArrayList<Integer>());
            
            // calculate the amount of nodes in this level, obtain this amount from queue
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // add cur to list
                list.get(list.size() - 1).add(cur.val);
                // add cur children to queue
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        
        return list;
    }
}