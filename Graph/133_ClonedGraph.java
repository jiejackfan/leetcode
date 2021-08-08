// 6/28/2021

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // Approach 1: DFS
    // O(nodes + edges)
    // O(nodes) hashmap
    // Keep a hashmap of visited, recur on every node and check if a node is already visited and has a copy
    // if not we create a copy and clone its neighbors as well
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        
        // if visited before, we return the cloned node
        if (visited.containsKey(node)) 
            return visited.get(node);
        
        // else if not visited before, we create a new node, put it into visited hash map and clone its neighbors
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        
        // for each neighbor of this node, we clone them for the newNode
        for (Node neighbor: node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return newNode;
    }
    
    // BFS
    // Create queue, use while loop to visit top node of queue. For each neighbor, visit
    // first and add to queue.
    // O(N + M)
    // O(N)
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        HashMap<Node, Node> visited = new HashMap<Node, Node>();
        
        // create queue and put first node in queue
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        
        // create clone, add clone to visited
        Node clone = new Node(node.val, new ArrayList());
        visited.put(node, clone);
        
        // bfs traversal while loop
        while (!queue.isEmpty()) {
            // pop node from front of queue
            Node n = queue.remove();
            
            // iterate through neighbors of this node and add each neighbor into queue
            for (Node neighbor: n.neighbors) {
                // create clone and add current node to queue
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                // link clone node with its cloned neighbor
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        
        //return cloned version of node
        return visited.get(node);
    }
}