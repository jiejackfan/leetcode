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
    // DFS
    // Visit each node, create a clone add the clone to visited hashmap and visit its neighbors
    // O(N + M) node + edges
    // O(N) visited hashmap space
    Map<Node, Node> visited = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        // recursive base case
        if (node == null) return node;
        
        // if node is visited, no need to clone
        if (visited.containsKey(node)) return visited.get(node);
        
        // create a empty clone
        Node cloneNode = new Node(node.val, new ArrayList());
        visited.put(node, cloneNode);
        
        // add the neighbor clones using recursion
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
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