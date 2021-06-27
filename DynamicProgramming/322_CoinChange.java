// 6/26/2021
// Watch the video for better written solution lol

class Solution {
    // memoization + recursion. Bottom up
    // O(s*n) where s = amount, n = # coins
    // O(s)
    // global memo table
    private Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount + 1];
        return recursionHelper(coins, amount);
    }
    
    private int recursionHelper(int[] coins, int remain) {
        // base case
        if (remain < 0) return -1;
        if (remain == 0) return 0;
        
        // if answer is in memo table
        if (memo[remain] != null) return memo[remain];
        
        // calculate a minimum count for specific value by going through all the coin values
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = recursionHelper(coins, remain - coin);
            if (count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }
        
        // update memo table
        memo[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[remain];
    }
    
    // Approach 2: dynamic programming
    // O(s * n)
    // O(n)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // starting case
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}