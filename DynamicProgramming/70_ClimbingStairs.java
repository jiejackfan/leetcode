// April 10, 2021

class Solution {
    
    // brute force
    // O(2^n) to recur on every node of this recursion tree 
    // O(n) memory needed for a tree of n level
    // Construct recursion of a tree of total steps. 
    public int climbStairs(int n) {
        return climb(0, n);
    }
    
    public int climb(int currStep, int totalStep) {
        if (currStep == totalStep) return 1;
        if (currStep > totalStep) return 0;
        return climb(currStep + 1, totalStep) + climb(currStep + 2, totalStep);
    }
    
    // Memoization w/ recursion
    // O(n) O(n)
    public int climbStairs(int n) {
        // 3 step will require 4 level tree
        int memo[] = new int[n+1];
        return climb(0, n, memo);
    }
    
    public int climb(int curr, int total, int[] memo) {
        if (curr > total) return 0;
        if (curr == total) return 1;
        if (memo[curr] > 0) return memo[curr];
        memo[curr] = climb(curr + 1, total, memo) + climb(curr + 2, total, memo);
        return memo[curr];
    }
    
    // Dynamic Programming
    // optimal substructure property. Optimal solution can be constructed from optimal solution of its subproblem
    // dp[i] = dp[i-1] + dp[i-2]
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        if (n == 1) return 1;
        
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}