// April 25, 2021

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
    
    // recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        traverse(node.left, list);
        traverse(node.right, list);
        list.add(node.val);
    }
    
    // Iterative
    // O(n)
    // O(height of tree)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList();
        Deque<TreeNode> stack = new ArrayDeque();
    
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if (!stack.isEmpty() && root.right == stack.peek()) {
                stack.pop();
                stack.push(root);
                root = root.right;
            } else {
                output.add(root.val);
                root = null;
            }
        }

        return output;
    }
}