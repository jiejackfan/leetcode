// 8/5/2021
class Solution {
    
    // Approach 2: BFS
    // Search every node, if a node is '1' then we trigger a BFS search
    // put neighbor nodes into queue and set node val to '0' to mark as visited
    // iteratively search until queue is empty
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] {-1, 0},
        new int[] {1, 0},
        new int[] {0, 1},
        new int[] {0, -1}
    ); 
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        
        int nr = grid.length;
        int nc = grid[0].length;
        int num_island = 0;
        
        // iterate every node
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++num_island;
                    grid[r][c] = '0'; // mark node as visited
                    
                    // build queue for BFS
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    
                    // start of BFS
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        
                        for (int[] direction : DIRECTIONS) {
                            int newR = row + direction[0];
                            int newC = col + direction[1];
                            if (newR < 0 || newR >= nr || newC < 0 || newC >= nc 
                                || grid[newR][newC] == '0')
                                continue;
                            grid[newR][newC] = '0';
                            neighbors.add(newR * nc + newC);
                        }
                    }
                }
            }
        }
        return num_island;
    }
}