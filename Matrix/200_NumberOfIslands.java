// 8/5/2021
class Solution {
    // Approach 1: DFS
    // O(n * m) go through all cells
    // O(n * m) recursion stack
    // for every cell, if we encounter a '1' then we do a DFS to set all of its nodes to '0'
    public int numIslands(char[][] grid) {
        int nr = grid.length;
        if (nr == 0 || grid == null) return 0;
        int nc = grid[0].length;
        
        int numIsland = 0;
        
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++numIsland;
                    dfs(grid, r, c);
                }
            }
        }
        return numIsland;
    }
    
    // dfs recursion to set current cell to '0' and also neighboring cells
    protected void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') 
            return;
        
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
    
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