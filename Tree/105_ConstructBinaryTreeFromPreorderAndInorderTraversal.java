// April 28, 2021

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
    
    // recursion DFS using preorder
    // O(n) visits every node once
    // O(n) inorderMap space
    int preorderIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // setup hashmap (inorder element, index) globally so helper function can access root in O(1) time
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        // start recursion in helper
        return recur(preorder, 0, preorder.length - 1);
    }
                     
    private TreeNode recur(int[] preorder, int left, int right) {
        // base case
        if (left > right) return null;
        
        // create node for current root
        int preorderVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(preorderVal);
        
        // create left and right children using recursion
        root.left = recur(preorder, left, inorderMap.get(preorderVal) - 1);
        root.right = recur(preorder, inorderMap.get(preorderVal) + 1, right);
        // return root
        return root;
    }
}