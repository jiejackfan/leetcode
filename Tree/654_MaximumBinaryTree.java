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
    // Approach: labuladong
    // need helper because we want to have a range
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }
    
    // pre order traversal
    public TreeNode build(int[] nums, int left, int right) {
        if (left > right)
            return null;

        // find the max index within given range and set max as new node
        int maxIdx = -1, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                maxIdx = i;
                max = nums[i];
            }
        }
        TreeNode newNode = new TreeNode(max);
        
        // process the children
        newNode.left = build(nums, left, maxIdx - 1);
        newNode.right = build(nums, maxIdx + 1, right);
        
        return newNode;
    }
}