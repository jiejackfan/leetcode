// 8/5/2021
class Solution {

    // Approach 1: BFS shortest path problem
    // Start BFS from the gates and every time we move we add 1 to the current tile value
    // O(m*n)
    // O(m*n)
    
    // Empty val
    private static final int EMPTY = Integer.MAX_VALUE;
    // Gate val
    private static final int GATE = 0;
    // Directions offset value
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1, 0},
        new int[] {-1, 0},
        new int[] {0, 1},
        new int[] {0, -1}
    );
    public void wallsAndGates(int[][] rooms) {
        // check edge case
        int m = rooms.length;
        if (m == 0) 
            return;
        int n = rooms[0].length;
        
        // init queue for BFS
        Queue<int[]> q = new LinkedList<>();
        
        // add all the gates into the queue first.
        // this way BFS starts from all the gates at once
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] {row, col});
                }
            }
        }
        
        // start BFS process
        // for each cell, find the 4 cells that surrounds it
        // for each future cell, if it is empty then we fill in its value with curr.val + 1
        // else we skip this cell because there is already a value
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != EMPTY) 
                    continue;
                
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] {r, c});
            } 
        }
    }
}