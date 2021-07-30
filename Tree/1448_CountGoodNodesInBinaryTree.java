// 7 28 2021

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
    // O(n) visit every node once
    // O(n) recursion stack
    // Build a dfs helper that keeps track of current maximum of path
    private int numGoodNodes = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
    
    private void dfs(TreeNode node, int maxSoFar) {
        // base case
        if (node == null)
            return;
        
        // check if currentNode is larger than maxSoFar
        if (maxSoFar <= node.val) {
            numGoodNodes++;
        }
        
        dfs(node.right, Math.max(node.val, maxSoFar));
        dfs(node.left, Math.max(node.val, maxSoFar));
    }
    
    // Approach 2: DFS iterative
    // Use a stack to simulate recursioon stack
    // O(n)
    // O(n)
    public int goodNodes(TreeNode root) {
        int numGoodNodes = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        
        // loop until stack is empty
        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            // check if this node has a value greater or equal to maxSoFar
            if (cur.node.val >= cur.maxSoFar) {
                numGoodNodes++;
            }
            
            if (cur.node.left != null) 
                stack.push(new Pair(cur.node.left, Math.max(cur.maxSoFar, cur.node.val)));
            if (cur.node.right != null) 
                stack.push(new Pair(cur.node.right, Math.max(cur.maxSoFar, cur.node.val)));
        }
        
        return numGoodNodes;
    }
    
    // Approach 3: BFS iterative using Queue
    public int goodNodes(TreeNode root) { 
        int numGoodNodes = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        
        while (queue.size() > 0) {
            Pair cur = queue.poll();
            if (cur.node.val >= cur.maxSoFar) {
                numGoodNodes++;
            }
            if (cur.node.left != null) {
                queue.offer(new Pair(cur.node.left, Math.max(cur.node.val, cur.maxSoFar)));
            }
            if (cur.node.right != null) {
                queue.offer(new Pair(cur.node.right, Math.max(cur.node.val, cur.maxSoFar)));
            }
        }
        return numGoodNodes;
    }
}

// for approach 2: 
class Pair {
    public TreeNode node;
    public int maxSoFar;
    
    public Pair (TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}