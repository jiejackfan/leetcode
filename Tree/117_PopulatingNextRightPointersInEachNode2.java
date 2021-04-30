// April 30, 2021

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // level order traversal with queue
    public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                
                // if at the last node in this level, don't assign a next pointer.
                if (i < levelSize-1) curr.next = queue.peek();
                
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return root;
    }
    
    
    // Level order traversal using previous next pointers.
    // This question utilizes a prev pointer to track the pairing of nodes because the this is not a full
    // binary tree.
    Node prev;
    Node leftmost;
    public Node connect(Node root) {
        if (root == null) return null;
        this.leftmost = root;
        
        while (this.leftmost != null) {
            this.prev = null;
            Node curr = this.leftmost;
            this.leftmost = null;
            while (curr != null) {
                processChild(curr.left);
                processChild(curr.right);
                curr = curr.next;
            }
        }
        return root;
    } 
    
    private void processChild(Node childNode) {
        if (childNode != null) {
            if (prev == null) {
                this.leftmost = childNode;
            } else {
                this.prev.next = childNode;
            }
            this.prev = childNode; 
        }
    }
} 