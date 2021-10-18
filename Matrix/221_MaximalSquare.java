class Solution {
    // Approach 1: Brute force
    // O((mn)^2) traverse complete matrix for all 1s
    // O(1)
    // When encounter a 1, check if there are 1s to the right, bottom, and diagnoal
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1; // size of current square
                    boolean flag = true; // can't make a square, stop the calculation
                    
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        // check cols for next square is 1
                        for (int k = j; k <= j + sqlen; k++) {
                            if (matrix[i+sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        // check rows for next square is 1
                        for (int k = i; k <= i + sqlen; k++) {
                            if (matrix[k][j+sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        
                        // increase sql size
                        if (flag)
                            sqlen++;
                    }
                    
                    maxsqlen = Math.max(maxsqlen, sqlen);   
                }
            }
        }
        
        return maxsqlen * maxsqlen;
    }
    
    // Approach 2: DP
    // maintain a dp table size of matrix. dp[i][j] will store the max square which index is the bottom right corner
    // O(m*n) O(m*n)
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows+1][cols+1];
        int maxsqlen = 0;
        
        // go through each element of matrix once
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
    
    // Approach 3: DP Better
    // Don't need to store the entire matrix, use 2 rows to do the same thing as above
    // O(m*n) O(n)
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        // this saves a row, so needs cols space + 1
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0; // prev is the dp[i-1][j-1] position
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp =dp[j];
                if (matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j-1], prev),dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}