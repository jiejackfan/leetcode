// April 4, 2021

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

    // Start from middle of given array build it as the parent node, and recur on left and right side to build subtrees.
    int nums[];
    // Pre-order traversal (node left right)
    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int p = (left+right) /2;
        //if there are even number of nodes, when left+right = odd
        if ((left+right) % 2 == 1) ++p;
        
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }
}