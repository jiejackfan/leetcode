// April 15, 2021
// 7/13/2021

class Solution {
    // Approach 1: Recursion top down memoization
    // O(n)
    // O(n)
    // standard memoization template, memo of max money we can earn from that starting index
    // build memo table
    int[] memo;
    public int rob(int[] nums) {
        this.memo = new int[nums.length];
        // fill memo array with -1
        Arrays.fill(this.memo, -1);
        return robFrom(0, nums);
    }
    // recursion helper: 
    // takes in i ==> position of the house
    // returns the max amount of money one can earn from this house and beyond
    private int robFrom(int i, int[] nums) {
        // base case: if we are past the last house, return 0.
        if (i >= nums.length) return 0;
        
        // check if the result belongs in memo
        if (memo[i] != -1) return memo[i];
        
        // calculate the maximum amount of money we can steal starting from this house
        // either we steal from this house + house 2 steps away from this house OR steal from the next house
        int steal = Math.max(nums[i] + robFrom(i + 2, nums), robFrom(i+1, nums));
        
        memo[i] = steal;
        return steal;
    }
    
    // Approach 2: DP bottom up
    // O(n)
    // O(n)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        // build dp table
        int[] maxRobAmount = new int[nums.length + 1];
        
        // initialize DP table last element to 0 (past the last house)
        // initialize second to last element to the last house price
        maxRobAmount[n] = 0;
        maxRobAmount[n-1] = nums[n-1];
        
        // going from the back towards the front, using the same logic as recursion
        for (int i = n - 2; i >= 0; i--) {
            maxRobAmount[i] = Math.max(nums[i] + maxRobAmount[i + 2], maxRobAmount[i + 1]);
        }
        
        return maxRobAmount[0];
    }
    
    
    // Approach 3: DP w/o table
    // O(n)
    // O(1)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        // initialize dp[i+2] to 0 
        // initialize dp[i+1] to last house price
        int robNextPlusOne = 0;
        int robNext = nums[n-1];
        
        // going from the back towards the front, using the same logic as recursion
        for (int i = n - 2; i >= 0; i--) {
            int rob = Math.max(nums[i] + robNextPlusOne, robNext);
            
            robNextPlusOne = robNext;
            robNext = rob;
        }
        
        return robNext;
    }
}