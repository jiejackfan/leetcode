class Solution {
    // Approach 1: Recursion w/ memoization (top down)

    
    // Approach 2: DP (bottom up) video solution
    public boolean canPartition(int[] nums) {
        // find sum of all elements
        int sum = 0;
        for (int num : nums) 
            sum += num;
    
        // if sum is odd, return false
        if (sum % 2 != 0)
            return false;
        
        // init dp
        int n = nums.length;
        sum /= 2;
        boolean[][] dp = new boolean[n+1][sum+1];
        
        // init last row as all false. base for dp. Java init to false
        // init first col, because the sum is 0. This is base for dp
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        
        // Go from left to right, bottom to top
        for (int i = n - 1; i>= 0; i--) {
            for (int j = 1; j <= sum; j++) {
                // if this num (row) is greater than sum, use last num's answer for this sum
                if (j < nums[i])
                    dp[i][j] = dp[i+1][j];
                
                // if we can try this num, either use this num or don't use this num
                else
                    dp[i][j] = dp[i+1][j-nums[i]];
            }
        }
        return dp[0][sum];
    }
}