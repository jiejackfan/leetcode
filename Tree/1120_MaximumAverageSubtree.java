// 7/25/2021
// Amazon OA 2

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
    
    // Approach 1: post order traversal
    // create a state class to store variable, not arrays
    class State {
        int nodeCount;
        int valueSum;
        double maxAverage;
        
        State(int nodes, int sum, double maxAverage) {
            this.nodeCount = nodes;
            this.valueSum = sum;
            this.maxAverage = maxAverage;
        }
    }
    
    public double maximumAverageSubtree(TreeNode root) {
        return maxAverage(root).maxAverage;
    }
    
    
    private State maxAverage(TreeNode root){
        if (root == null) {
            return new State(0, 0, 0);
        }
        
        // post order so visit child first
        State left = maxAverage(root.left);
        State right = maxAverage(root.right);
        
        // now find nodeCount, valueSum and maxAverage for current root node
        int nodeCount = left.nodeCount + right.nodeCount + 1;
        int sum = left.valueSum + right.valueSum + root.val;
        double maxAverage = Math.max((1.0 * sum) / nodeCount, Math.max(left.maxAverage, right.maxAverage));
        
        return new State(nodeCount, sum, maxAverage);
    }
    
}