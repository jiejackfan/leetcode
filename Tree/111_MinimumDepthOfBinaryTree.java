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

    // Approach labuladong
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int res = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res++;
        }
        return res;
    }
    
    // Approach 1: Recursion
    // DFS recursion that is bottom up approach 
    // O(n)
    // O(n) worst, O(H) == O(logn) avg
    public int minDepth(TreeNode root) {
        // base case: if we are at null, return 0 height
        if (root == null)
            return 0;
        // base case: if we are at leaf, return 1 height
        if (root.left == null && root.right == null) 
            return 1;
        
        // find the min depth using recursion on the left and right subtree
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) 
            min_depth = Math.min(minDepth(root.left), min_depth);
        if (root.right != null) 
            min_depth = Math.min(minDepth(root.right), min_depth);
        
        return 1 + min_depth;
    }
    
    
    // Approach 2: DFS Iteration
    // Using stack to simulat DFS. Top down, so starting counting levels at the first level.
    // O(n)
    // O(n)
    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        
        // check edge case where root is null
        if (root == null) 
            return 0;
        else 
            stack.add(new Pair(root, 1));
        
        // setup global min_depth for answer
        int min_depth = Integer.MAX_VALUE;
        
        // DFS loop
        while (!stack.isEmpty()) {
            // get last element
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            
            // update min_depth at leaf node
            if (root.left == null && root.right == null) {
                min_depth = Math.min(current_depth, min_depth);
            }
            
            if (root.left != null) 
                stack.addLast(new Pair(root.left, current_depth+1));
            if (root.right != null) 
                stack.addLast(new Pair(root.right, current_depth+1));
        }
        
        return min_depth;
    }
    
    // Approach 3: BFS Iteration
    // O(n)
    // O(n)
    // Using a queue, use BFS so we can early stop.
    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        if (root == null)
            return 0;
        else 
            queue.addLast(new Pair(root, 1));
        
        int min_depth = Integer.MAX_VALUE;
        
        // start of BFS loop
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.pollFirst();
            root = current.getKey();
            int current_depth = current.getValue();
            
            // update min_depth at leaf node
            if (root.left == null && root.right == null) 
                min_depth = Math.min(min_depth, current_depth);
            
            if (root.left != null)
                queue.addLast(new Pair(root.left, current_depth + 1));
            if (root.right != null) 
                queue.addLast(new Pair(root.right, current_depth + 1));
        }
        
        return min_depth;
    }
}