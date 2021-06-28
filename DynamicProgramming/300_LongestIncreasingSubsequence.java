// 6/27/2021


class Solution {
    // DP youtube solution: https://www.youtube.com/watch?v=cjWnW0hdF1Y&t=948s
    // Going from the back of dp table, the dp update rule is dp[i] = max(dp[i], 1+dp[i + 1], ...)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1]  = 1;
        
        // calculate and fill in dp table
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                // update table only if there is increasing
                if (nums[i] < nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        
        // answer is the maximum value within dp array
        int max = Integer.MIN_VALUE;
        for (int num : dp) max = Math.max(max, num);
        return max;
    }
}