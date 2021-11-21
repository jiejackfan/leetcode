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
<<<<<<< HEAD
=======

    
>>>>>>> 7968cbd755c7041b5c01cfc2d67e0ffaf29dd7fd
    // Approach 1: BFS w/ level length
    // BFS is the most intuitive, we just need to find the last element on each row
    // O(n) O(w) w=width of the longest row in the tree, worst case O(n)
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) 
            return new ArrayList<Integer>();
        
        // init queue and answer list
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> rightside = new ArrayList<Integer>();
        
        // add first node and start bfs
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            
            for (int i = 0; i < levelLength; i++) {
                // get node
                TreeNode node = queue.poll();
                // if node is last in this row, add to answer
                if (i == levelLength - 1) {
                    rightside.add(node.val);
                }
                // add left and right child to the queue for next row iteration
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null) 
                    queue.offer(node.right);
            }
        }
        return rightside;
    }
    
    
}