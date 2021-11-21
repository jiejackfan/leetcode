class Solution {
    // Approach 1: Recursion w/ memo
    // Trying +/- for each element
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums, 0, 0, target);
        return count;
    }
    
    public void calculate(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target)
                count++;
            return;
        }
        
        calculate(nums, i+1, sum + nums[i], target);
        calculate(nums, i+1, sum - nums[i], target);
        return;
    }
    
    // Approach 2: DP
    // use dp rule: dp[i][sum+nums[i]] =  dp[i][sum+nums[i]] + dp[i-1][sum]
    // since dp sum can be negative, we use positive index offset 
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) {
                if (dp[i-1][sum+total] > 0) {
                    dp[i][sum+nums[i]+total] += dp[i-1][sum+total];
                    dp[i][sum-nums[i]+total] += dp[i-1][sum+total];
                }
            }
        }
        
        return Math.abs(target) > total? 0 : dp[nums.length - 1][target + total];
    }
}