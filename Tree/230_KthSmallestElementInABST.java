
// 07/02/2021

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
    // Recursion inorder DFS
    // O(n)
    // O(n)
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> elements = inorder(root, new ArrayList<Integer>());
        return elements.get(k - 1);
    }
    
    // recursion helper
    private ArrayList<Integer> inorder(TreeNode node, ArrayList<Integer> list) {
        // base case
        if (node == null) return list;
        
        // inorder traversal: left -> node -> right
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
        
        return list;
    }
    
    // Iterative inorder using stack
    // O(height)
    // O(height)
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            
            // eliminate elements one by one, only go in 2nd while loop after all elements are eliminated
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    // expanding system design how to deal with frequent insert and search
    // store in order list with linked list, 
}