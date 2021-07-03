// 6/30/2021

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // O(n)
    // O(logn) recursion tree stack
    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }
    
    // recursion helper
    private String reserialize(TreeNode node, String str) {
        // base case: if reach leaf's children, add null to our answer string
        if (node == null) {
            str += "null,";
        }
        // add cur node value and let recursion add children value
        else {
            str += str.valueOf(node.val) + ",";
            str = reserialize(node.left, str);
            str = reserialize(node.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // split string data by comma
        String[] data_array = data.split(",");
        // convert array of string into list of strings
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        // enter recursion
        return redeserialize(data_list);
    }
    
    // process the tree in a DFS queue way, read from the beginning (0th index)
    private TreeNode redeserialize(List<String> l){
        // base case
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        
        // built new node and let recursion generate the children
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = redeserialize(l);
        root.right = redeserialize(l);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));