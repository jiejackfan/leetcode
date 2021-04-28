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
    
    // recursion: reverse of preorder
    // build from root --> right --> left
    // O(n)
    // O(n) hashmap
    
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preOrder;
    int preOrderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        preOrderIndex = 0;
        
        
        int index = 0;
        for (int e : inorder) {
            map.put(e, index++);
        }
        
        return build(0, preorder.length - 1);
    }
    
    private TreeNode build(int left, int right) {
        if (left > right) return null;
        
        int root = preOrder[preOrderIndex];
        int rootIndex = map.get(root);
        preOrderIndex++;
        
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = build(left, rootIndex - 1);
        rootNode.right = build(rootIndex + 1, right);
        
        return rootNode;
    }
}