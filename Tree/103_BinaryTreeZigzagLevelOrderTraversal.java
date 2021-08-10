// 8/10/2021

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
    // Approach 1: BFS
    // O(n)
    // O(n) array we keep final output
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) 
            return new ArrayList<List<Integer>>();
        
        // List of list for result return
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        // build bfs queue
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);
        
        // build deque structure for building each level
        LinkedList<Integer> level_list = new LinkedList<Integer>();
        // boolean variable for identifying if this level is left to right (true) or 
        // right to left (false);
        boolean is_order_left = true;
        
        // start BFS:
        while (node_queue.size() > 0) {
            // poll from the front of the queue to do BFS
            TreeNode curr_node = node_queue.pollFirst();
            
            // if this node is a regular node, add this node to the deque
            // also add child nodes on the next level into BFS queue
            if (curr_node != null) {
                // if we want to add from left to right, add to the end of queue
                if (is_order_left) {
                    level_list.addLast(curr_node.val);   
                }
                else{
                    level_list.addFirst(curr_node.val);
                }
                
                // check children and add to BFS
                if (curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }
                if (curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }
                
            }
            // if this node is a null delimiter, we know this level is finished
            // so add this level deque into the final result list
            else {
                results.add(level_list);
                level_list = new LinkedList<Integer>();
                
                // add delimiter to the new level
                if (node_queue.size() > 0) {
                    node_queue.addLast(null);
                }
                is_order_left = !is_order_left;
            }
        }
        
        return results;
    }
}