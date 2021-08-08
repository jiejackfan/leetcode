// 8/7/2021
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    // Approach 1: Recursion
    // O(n) 
    // o(n) recursion stack
    // Use recursion to find current node's next and random pointer
    // to prevent going in a infinite loop (b.c. random pointer), keep track of nodes that are visited using a hashtable
    // HashMap holds old node as key and new node as values
    Map<Node, Node> visitedHash = new HashMap<Node, Node>();
    
    // returns the head node of a new list, recurs on itself
    public Node copyRandomList(Node head) {
        if (head == null) 
            return null;
        
        // if we already processed this node, we return the cloned version of it
        if (this.visitedHash.containsKey(head))
            return this.visitedHash.get(head);
        
        // else we create a new clone node out of this head node
        Node node = new Node(head.val);
        
        // save this node as visited, so our random pointer does not enter infinite loop 
        this.visitedHash.put(head, node);
        
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        
        return node;
    }
    
    // Approach 2: Iteration
    // O(n) visit every node
    // O(n) storage for visited
    // hashtable to hold old node as key and new node as value
    Map<Node, Node> visited = new HashMap<Node, Node>();
    
    // helper function that will find the next/random nodes if they exist in visted
    private Node getClonedNode(Node node) {
        if (node == null) return null;
        
        // if this node is already visted, return that cloned node
        if (visited.containsKey(node)) 
            return visited.get(node);
        
        // else create this node and return it
        else {
            Node newNode = new Node(node.val);
            visited.put(node, newNode);
            return visited.get(node);
        }
    } 
    
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        Node oldNode = head;
        
        // create a new head node and put it into the hashtable
        Node newNode = new Node(oldNode.val);
        visited.put(oldNode, newNode);
        
        // iterate using the next pointers until all nodes are cloned
        while (oldNode != null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            
            // prepare for next iteration
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        
        return visited.get(head);
    }
    
    
    // Approach 3: Iterative with constant space
    
}