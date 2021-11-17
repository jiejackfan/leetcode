// 4/27/2021

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
    // same logic as 105
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1,
                        postorder, 0, postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int instart, int inend,
                            int[] postorder, int poststart, int postend) {
        if (poststart > postend) 
            return null;
        
        // get root val from back of postorder,
        // get root index from inorder
        int rootval = postorder[postend];
        int rootidx = -1;
        for (int i = instart; i<= inend; i++) {
            if (inorder[i] == rootval){
                rootidx = i;
                break;
            }
        }
        
        // build new root and recur to find the children tree
        TreeNode root = new TreeNode(rootval);
        int leftSize = rootidx - instart;
        root.left = build(inorder, instart, rootidx-1,
                            postorder, poststart, poststart+leftSize-1);
        root.right = build(inorder, rootidx+1, inend,
                            postorder, poststart+leftSize, postend-1);
        
        return root;
    }
    
    // Reverse of post order.
    // Build the tree by building root-->right-->left. 
    // Last element in the post order is the root. In inorder, the element to left of root index is left subtree,
    // elements to tright of root index is right subtree. 
    // O(n) 
    // O(n) hashmap storage
    
    int postOrderIndex;
    int[] postOrder;
    int[] inOrder;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrder = postorder;
        inOrder = inorder;
        postOrderIndex = postorder.length - 1;
        
        int index = 0;
        for (int order : inorder) {
            map.put(order, index++);
        }
        
        return construct(0, postorder.length - 1);
    }
    
    private TreeNode construct (int left, int right) {
        if (left > right) return null;
        
        int root = postOrder[postOrderIndex];
        postOrderIndex--;
        int indexOfRoot = map.get(root);
        
        TreeNode rootNode = new TreeNode(root);
        rootNode.right = construct(indexOfRoot + 1, right);
        rootNode.left = construct(left, indexOfRoot - 1);

        return rootNode;
    }
}