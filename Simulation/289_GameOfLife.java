class Solution {
    // Updating simultaneously means apply the rules at the same time
    // a cell can't be influenced by 2 rules at the same time
    
    // Approach 1: O(mn) space solution. 
    // O(m*n) loop every cell
    // O(m * n) we save a copy of original board
    // Make a copy of this baord, apply rules in copy and put the result
    // into original board
    public void gameOfLife(int[][] board) {
        // direction array to find neighboring cells
        int[] neighbors = {0, 1, -1};
        
        int rows = board.length;
        int cols = board[0].length;
        
        // create copy of original board
        int[][] copyBoard = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }
        
        // iterate cell by cell, find neighbors of each cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // for each cell, count total neighbors that are 1
                // 8 neighbors
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i]== 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            // Using copy array, check if neighbor is out of range
                            // and add 1 to liveNeighbor.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) 
                                && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                
                // use the liveNeighbors to apply different rules
                // rule 1 or rule 3: die b.c. under and over population
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }
                
                // rule 4: born because have exactly 3 neighbor
                if ((copyBoard[row][col] == 0) && (liveNeighbors == 3)) {
                    board[row][col] = 1;
                }
                
                // rule 2 can be ignored because no changes need to happen with exactly 2 live neighbor
            }
        }
    }
    
    
    // Approach 2: O(1) space
    // Instead of copy board, we can change cell values to -1 (dead but alive before)
    // and 2  (live but dead before)
    
    
}