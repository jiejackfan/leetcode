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
    // Approach 1: DFS find parent and BFS
    // O(n) O(n)
    // Use DFS to find and mark parent for all nodes
    // Do BFS from target and stop at distance k
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        parent = new HashMap();
        // find parents of all nodes
        dfs(root, null);
        
        // queue used for 
        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);
        
        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);
        
        int dist = 0;
        // bfs from the target node
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // if node is null, we know we finished all level of dist k
            if (node == null) {
                // if we reached dist k, prep and return ans
                if (dist == k) {
                    List<Integer> ans = new ArrayList<>();
                    for (TreeNode n:queue)
                        ans.add(n.val);
                    return ans;
                }
                // if not dist k yet, add null to queue to begin next level iteration
                queue.offer(null);
                dist++;
            }
            else {
                if(!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<Integer>();
    }
    
    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}