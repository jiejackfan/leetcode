// April 19, 2021

class Solution {
    
    // O(1) only one iteration of all 81 cells
    // O(1) 27 hashtable for storage
    // make HashMap arrays for row, column, box to record appearances of numbers,
    // one pass through all elements and check if theres a duplicate at the same time
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char n = board[i][j];
                if (n != '.') {
                    int num = (int) n;
                    int boxNum = (i / 3) * 3 + j / 3;
                    
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                    boxes[boxNum].put(num, boxes[boxNum].getOrDefault(num, 0) + 1);
                    
                    if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[boxNum].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}