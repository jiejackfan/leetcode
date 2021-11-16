// April 29, 2021

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
    // Level order traversal
    // Save elements level by level in a queue, like we typically do for bfs.
    // For each node, its next pointer points to the head of the current queue.
    // O(n)
    // O(n)
    public Node connect(Node root) {
        if (root == null) return null;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                
                if (i < levelSize - 1)
                    curr.next = queue.peek();
                
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        
        return root;
    }
    
    // level order traversal by using previously set pointer
    // for each level, we can link the children together because we have this broad vision. 
    // 2 different situations will arise. One the left children connects to right children which the parent has access to. 
    // Second the right children connects to left children of another parent, we can get access to the other parent node by accessing
    // the next pointer of the parent.
    public Node connect(Node root) {
        Node leftmost = root;
        
        // while not on the last level of tree
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                // connection type 1:
                head.left.next = head.right;
                // connection type 2:
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        
        return root;
    }

    // approach 3 : labuladong
    // pre-order traversal with helper function
    // need helper because we want to connect 2 diff nodes as well
    public Node connect(Node root) {
        if (root == null)
            return null;
        
        connect2(root.left, root.right);
        return root;
    }
    
    public void connect2(Node n1, Node n2) {
        if (n1 == null || n2 == null)
            return;
        
        // manipulate root
        n1.next = n2;
        connect2(n1.right, n2.left);

        // do the same to their children
        connect2(n1.left, n1.right);
        connect2(n2.left, n2.right);
    }
}