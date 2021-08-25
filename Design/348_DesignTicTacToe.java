// 8/25/2021

class TicTacToe {
    
    // Approach 1: Optimized Brute force
    // O(4n) check 4 row/column/diagonals 
    // O(n^2) store n * n board
    // Traditional tic-tac-toe checks the entire board every time we check win.
    // In this optimized approach, we only look at specific row/column/diagnal to check wins
    // 
    /** Initialize your data structure here. */
    private int[][] board;
    private int n;
    
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // insert new player position
        board[row][col] = player;
        
        // check if player wins
        if ((checkRow(row, player)) || (checkCol(col, player)) || (row == col && checkDiagonal(player))
           || (col == n - row - 1 && checkAntiDiagonal(player))) 
            return player;
        
        // else no winner yet, return 0
        return 0;
    }
    
    // helper: diagonal have coordinate (00, 11, 22) 
    private boolean checkDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player)
                return false;
        }
        return true;
    }
    
    // helper: anti-diagonal have coordinate (02,11,20)
    private boolean checkAntiDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][n-i-1] != player)
                return false;
        }
        return true;
    } 
    
    // helper: check current row win
    private boolean checkRow(int row, int player) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player)
                return false;
        }
        return true;
    }
    
    // helper: check current col win
    private boolean checkCol(int col, int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != player)
                return false;
        }
        return true;
    }
    
    // Approach 2: Optimized Approach
    // O(1)
    // O(n)
    // Count how many times a particular row/col/diagonal have been marked
    // rows and col will be array, diagonals can be counted with int
    // player 1 +1, player 2 -1. So if a number becomes n, player 1 wins. Vice versa
    int[] cols;
    int[] rows;
    int diagonal;
    int antiDiagonal;
    
    public TicTacToe(int n) {
        cols = new int[n];
        rows = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }
    
    public int move(int row, int col, int player) {
        // determine which value to add to arrays
        int val = (player == 1)? 1 : -1;
        
        int n = rows.length;
        // update rows/cols/diagonal
        rows[row] += val;
        cols[col] += val;
        if (row == col)
            diagonal += val;
        if (row == n - col - 1) 
            antiDiagonal += val;
        
        // check if player wins with absolute value
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n 
            || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */