// April 15, 2021

class Solution {
    // Recursion with memoization
    // O(n) recursion on every element and O(1) on each element
    // O(n) by cache and recursion stack
    // Visit every possible choice we can make, which we can use recursion. Subproblems repeat so use memoization
    int [] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robFrom(0, nums);
    }
    
    private int robFrom(int house, int[] nums) {
        if (house >= nums.length) {
            return 0;
        }
        
        if (memo[house] != -1) return memo[house];
        
        int ans = Math.max(robFrom(house + 1, nums), robFrom(house + 2, nums) + nums[house]);
        
        memo[house] = ans;
        return ans;
    }
    
    // Dynamic programming
    // O(n) O(n)
    // Keep dynamic programming table
    public int rob(int[] nums) {
        int numsLength = nums.length;
        
        int dp[] = new int[numsLength + 1];
        
        if (numsLength == 0) {
            return 0;
        } 
        
        dp[numsLength] = 0;
        dp[numsLength - 1] = nums[numsLength - 1];
        
        for (int i = numsLength - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], dp[i+2] + nums[i]);
        }
        
        return dp[0];
    }
    
    //Optimized Dynamic Programming
    // Keep 2 variables instead of a table, same as dynamic programming table 
    // O(n) O(1)
    public int rob(int nums[]) {
        int N = nums.length;
        
        if (N == 0) return 0;
        
        int robNext = nums[N - 1];
        int robNextPlusOne = 0;
        
        for (int i = N - 2; i >= 0; i--) {
            int rob = Math.max(robNext, robNextPlusOne + nums[i]);
            robNextPlusOne = robNext;
            robNext = rob;
        }
        
        return robNext;
    }
    
}