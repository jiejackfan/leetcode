//7/12/2021
class Solution {
    // Approach 1: Top down memoization
    // Hashmap for each sum value: key->sum, value-># of combinations
    private HashMap<Integer, Integer> memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new HashMap<>();
        return combs(nums, target);
    }
    private int combs(int[] nums, int remain) {
        // base case: 
        if (remain == 0)
            return 1;
        if (memo.containsKey(remain))
            return memo.get(remain);
        
        int result = 0;
        for (int num: nums) {
            if (remain - num >= 0) {
                result += combs(nums, remain - num);
            }
        }
        
        memo.put(remain, result);
        return result;
    }
    
    // Approach 2: dp bottom up  
    public int combinationSum4(int[] nums, int target) {
        //initialzie dp array and dp[0] as 1
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int combSum = 1; combSum <= target; combSum++) {
            for (int num: nums) {
                if (combSum - num >= 0) {
                    dp[combSum] += dp[combSum - num];
                }
            }
        }
        
        return dp[target];
    }
}