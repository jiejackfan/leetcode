class Solution {
    
    // Approach 1: brute force without constant space
    // O(M*N)
    // O(M+N)
//     public void setZeroes(int[][] matrix) {
//         int R = matrix.length;
//         int C = matrix[0].length;
//         Set<Integer> rows = new HashSet<Integer>(); // store empty row info
//         Set<Integer> cols = new HashSet<Integer>(); // store empty col info
        
//         // mark rows and cols that will become zero
//         for (int i = 0; i < R; i++) {
//             for (int j = 0; j < C; j++) {
//                 if (matrix[i][j] == 0) {
//                     rows.add(i);
//                     cols.add(j);
//                 }
//             }
//         }
        
//         // iterate once more to update matrix using the hashsets
//         for (int i = 0; i < R; i++) {
//             for (int j = 0; j < C; j++) {
//                 if (rows.contains(i) || cols.contains(j)) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }
    
    
    // Approach 2: constant space
    // Set the 0th value to 0 first time visiting any 0 value in matrix
    // go around a second time to set all row and column to 0. 
    // For first row and col theres a new variable to resolve conflict.
    // O(n * m)
    // O(1)
    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;
    
        
        for (int i = 0; i < R; i++) {
            // if first column has 0, update to isCol variable because first col and row share matrix[0][0] and cant be used at the same time
            if (matrix[i][0] == 0)
                isCol = true;
            
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
            
        }
        
        // iterate over array once again and update elements
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }    
            }
        }
        // see if first row needs to be set to zero
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
                
        }
        // see if first col needs to be set to zero
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}