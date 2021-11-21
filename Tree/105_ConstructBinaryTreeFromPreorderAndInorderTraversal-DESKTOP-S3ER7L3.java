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

    // Approach : labuladong
    // preorder traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1,
                        inorder, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        
        // find the root from the first of preorder
        // also find the root's index in inorder
        int rootVal = preorder[preStart];
        int rootIdx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                rootIdx = i;
                break;
            }
        }
        
        // build root and do the same steps for children
        TreeNode root = new TreeNode(rootVal);
        int leftTreeLength = rootIdx - inStart;
        root.left = build(preorder, preStart+1, preStart+leftTreeLength,
                            inorder, inStart, rootIdx-1);
        root.right = build(preorder, preStart+leftTreeLength+1, preEnd,
                            inorder, rootIdx+1, inEnd);
        
        return root;
    }
    
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