class Solution {
    // Approach 1: DFS
    // O(V + E)
    // O(V + E)
    // Use DFS to find topological sorted order
    // When reach end of DFS, we add the node in stack. Reverse stack to get
    // the final answer.
    // When reaching a gray course during recursion, we know theres a cycle
    
    static int WHITE = 1; // means course not visited
    static int GRAY = 2; // means course is in recursion
    static int BLACK = 3; // means course is done recursing and added to list already
    
    boolean isPossible;
    Map<Integer, Integer> color; // stores color of each course
    Map<Integer, List<Integer>> adjList; // adjacency list of graph
    Deque<Integer> topologicalOrder; // stack to store DFS result
    
    // init, build adjList, call DFS recursion, print stack
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);
        
        // create adjList
        // for every connection, 
        for (int i = 0; i < prerequisites.length; i++) {
            int des = prerequisites[i][0];
            int src = prerequisites[i][1];
            // get the neighbors current list for this course
            List<Integer> neighbor = adjList.getOrDefault(src, new ArrayList<Integer>());
            neighbor.add(des);
            adjList.put(src, neighbor);
        }
        
        // process every node, call DFS on each
        for (int i = 0; i < numCourses; i++) {
            if (this.color.get(i) == WHITE)
                this.dfs(i);
        }
        
        // pop topological stack and build ans array
        int[] ans;
        if (this.isPossible) {
            ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = this.topologicalOrder.pop();
            }
        } else {
            ans = new int[0];
        }
        
        return ans;
    }
    
    // init DS and set color of courses to all WHITE
    private void init (int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayDeque<Integer>();
        
        // build the color map with all white
        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }
    
    // 
    private void dfs(int node) {
        // don't recurse if we found a cycle (path leading to GRAY course)
        if (!this.isPossible) return;
        
        // start recursion by changing this course GRAY
        this.color.put(node, GRAY);
        
        // traverse all its neighbors. If the neighbor color is white, do DFS recur.
        // If the neighbor is GRAY, we have encountered a cycle. 
        // If the neighbor is BLACK, do nothing.
        for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<>())) {
            if (this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            } else if (this.color.get(neighbor) == GRAY) {
                this.isPossible = false;
            }
        }
        
        // recursion ends, mark current node BLACK and add to stack
        this.color.put(node, BLACK);
        this.topologicalOrder.push(node);
    }
    
    // Approach 2: In Degree (Khan's Algorithm)
    
}