// 7/17/2021

class Solution {
    // Approach 1: Backtrack recursion
    // Going from the bottom right corner up to the start
    // observe pattern where uniquePath(m, n) = uniquePath(m-1, n) + uniquePath(m, n-1)
//     public int uniquePaths(int m, int n) {
//         // base case, starting index for both m and n is 1
//         if (m == 1 || n == 1) return 1;
        
//         // return the recursion result
//         return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
//     } 
    
    
    // Approach 2: DP
    // O(n * m)
    // O(n * m)
    // DP solution using the same logic, starting index changes back to 1 ffs be consistent
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // fill in the arrays with 1s, but we only need the 0th col and row to be 1
        for (int[] arr: dp) {
            Arrays.fill(arr, 1);
        }
        
        // start filling up the dp array from top left towards bottom right
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}