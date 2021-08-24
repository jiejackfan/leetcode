// 8/23/2021

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // Approach 1: Recursion DFS Postorder
    // O(n) O(n)
    // Use a boolean flag to indicate we have found one TreeNode in the subtree. We know the answer if we are at the node
    // where there are 2 boolean flag after recursion.
    private TreeNode ans = null;  
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
    
    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        // base case: if we reach end of a branch, return false
        if (root == null)
            return false;
        
        // Do left and right dfs recursion to find if the search treenode is in its subtree
        // then check current node if it is one of the searched
        int left = this.recurseTree(root.left, p, q)? 1: 0;
        int right = this.recurseTree(root.right, p, q)? 1: 0;
        int mid = (root == p || root == q) ? 1 : 0;
        
        // if any two flags are 1 (true) then we know this node is common ancester
        if (mid + left + right >= 2) {
            this.ans = root;
        }
        
        return (mid + left + right > 0);
    }
    
    // Approach 2: Iterative using parent pointers 
    // using a stack dfs for iteration. Iterate through eveyr node until we find both p and q. While iterating
    // we store each node and its parents in a hashmap. After interating, we go through p and its parents to build
    // a set. Check q and its parents and if one matches the set that node is the common ancestor.
    // O(n) O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // stack for dfs tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        // hashmap for parent pointers
        // key saves current node, value saves its parent. This way we can backtrack to parent nodes
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        
        parent.put(root, null);
        stack.push(root);
        
        // iterate until we find both nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            
            // keep saving parent pointers in the subtree
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Build an acestor set to store all ancestor for node p
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // now trace back from q to its parents, see if any matches in p's ancestor. If theres
        // a match, then we know we have a common ancestor.
        while (!ancestors.contains(q)) 
            q = parent.get(q);

        return q;
    }
}