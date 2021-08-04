// 8/4/2021
class Solution {
    
    // Approach 1: Backtracking problem 
    // O(n * 3^L) n=# of cells   L=length of word   3 is the directions
    // O(L) recursion stack can be max of L length
    private char[][] board;
    private int ROWS;
    private int COLS;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        
        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0; col < this.COLS; ++col) {
                if (this.backtrack(row, col, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    protected boolean backtrack(int row, int col, String word, int index) {
        // base case: 
        if (index >= word.length()) {
            return true;
        }
        
        // check if this position is out of bound
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS || this.board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // explore next level DFS
        boolean ret = false;
        
        // mark path before next exploration so no repeated characters are used
        this.board[row][col] = '#';
        
        // DFS on 4 directions
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            ret = backtrack(row + rowOffset[i], col + colOffset[i], word, index+1);
            if (ret) 
                break;
        }
        
        // unmark path
        this.board[row][col] = word.charAt(index);
        return ret;
        
    }
}