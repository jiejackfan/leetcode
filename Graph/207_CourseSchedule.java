// 7/18/2021

// new GNode class acting is graph node, used in approach 3
class GNode {
    public Integer inDegrees = 0;
    public List<Integer> outNodes = new LinkedList<Integer>();
}

class Solution {
    
    // Approach 1: backtracking 
    // O(e + v^2) e=# of dependencies, v=# of courses
    // O(e + v) graph data, path data, recursion stack
    // Build graph with adjacency list and check if graph is DAG (directed acyclic graph)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();
        
        // build graph
        for (int[] relation: prerequisites) {
            // relation[0] depends on relation[1] based on problem def
            // if this node is already in couseDict
            if (courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        } 
        
        // 
        boolean[] path = new boolean[numCourses];
        
        // go through every course and check if we can find a cycle in the graph
        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            // check cycle using recursion
            if (this.isCyclic(currCourse, courseDict, path)) {
                return false;
            }
        }
        
        return true;
    }
    
    // backtrack helper checks no cycle would be formed starting from currCourse
    // path array stores true if cycle found with path starting from that particular node
    private boolean isCyclic (Integer currCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] path) {
        // base case
        if (path[currCourse]) return true;
        
        // no course found, return false
        if (!courseDict.containsKey(currCourse)) return false;
        
        // mark node in path as true before backtracking
        path[currCourse] = true;
        
        // backtracking
        boolean ret = false;
        for (Integer nextCourse: courseDict.get(currCourse)) {
            ret = this.isCyclic(nextCourse, courseDict, path);
            if (ret) break;
        }
        
        // remove node from path after backtracking
        path[currCourse] = false;
        return ret;
    }
    
    
    // Approach 2: DFS (backtrack plus memo)
    // O(e + v)
    // O(e + v)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();
        
        // build graph
        for (int[] relation: prerequisites) {
            // relation[0] depends on relation[1] based on problem def
            // if this node is already in couseDict
            if (courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        } 
        
        // 
        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        
        // go through every course and check if we can find a cycle in the graph
        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            // check cycle using recursion
            if (this.isCyclic(currCourse, courseDict, checked, path)) {
                return false;
            }
        }
        
        return true;
    }
    
    // backtrack helper checks no cycle would be formed starting from currCourse
    // path array stores true if cycle found with path starting from that particular node
    private boolean isCyclic (Integer currCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] checked, boolean[] path) {
        // checked cases can be skipped directly
        if (checked[currCourse]) return false;
        
        // base case
        if (path[currCourse]) return true;
        
        // no course found, return false
        if (!courseDict.containsKey(currCourse)) return false;
        
        // mark node in path as true before backtracking
        path[currCourse] = true;
        
        // backtracking
        boolean ret = false;
        for (Integer nextCourse: courseDict.get(currCourse)) {
            ret = this.isCyclic(nextCourse, courseDict, checked, path);
            if (ret) break;
        }
        
        // remove node from path after backtracking
        path[currCourse] = false;
        
        // add this node to checked
        checked[currCourse] = true;
        return ret;
    }
    
    // Approach 3: Topological sort
    // O(e + v)
    // O(e + v)
    // designed to find DAG cycles
    // remove visited edge from the graph, after visiting all nodes if there are edges left then this graph has cycles.
    
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
        if (prerequisites.length == 0) 
            return true;
        
        // courses -> list of next courses
        HashMap<Integer, GNode> graph = new HashMap<>();
        
        // build the graph
        for (int[] relation: prerequisites) {
            // relation[1] -> relation[0]
            GNode prevCourse = this.getCreateGNode(graph, relation[1]);
            GNode nextCourse = this.getCreateGNode(graph, relation[0]);
            
            prevCourse.outNodes.add(relation[0]);
            nextCourse.inDegrees += 1;
            
        }
        
        // start from courses that have no prerequisites
        int totalDeps = prerequisites.length;
        // add to no dependency courses array all the courses that have indegree of 0
        LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
        for (Map.Entry<Integer, GNode> entry: graph.entrySet()) {
            GNode node = entry.getValue();
            if (node.inDegrees== 0) 
                nodepCourses.add(entry.getKey());
        }
        
        //
        int removedEdges = 0;
        while (nodepCourses.size() > 0) {
            Integer course = nodepCourses.pop();
            
            for (Integer nextCourse : graph.get(course).outNodes) {
                GNode childNode = graph.get(nextCourse);
                childNode.inDegrees -= 1;
                removedEdges += 1;
                if (childNode.inDegrees == 0) 
                    nodepCourses.add(nextCourse);
            }
        }
        
        // if there are still dependecies left, then there are cycles
        if (removedEdges != totalDeps) {
            return false;
        } else 
            return true;
    }
    
    // retrieve existing <key, value> from graph, otherwise create a new one
    protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
        GNode node = null;
        if (graph.containsKey(course)) {
            node = graph.get(course);
        } else {
            node = new GNode();
            graph.put(course, node);
        }
        
        return node;
    }
}