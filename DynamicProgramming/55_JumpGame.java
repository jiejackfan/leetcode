// 7/17/2021

class Solution {
    // Approach 1: backtrack recursion 
    // O(2^n) tree traverse time complexity
    // O(n) recursion stack
    public boolean canJump(int[] nums) {
        return recur(0, nums);
    }
    
    private boolean recur (int position, int[] nums) {
        // base case if we reach thelast index
        if (position == nums.length - 1) return true;
        
        // find out how many steps from this index we can take
        // recur on every position to see if we can reach the end
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (recur(nextPosition, nums)) {
                return true;
            }
        }
        
        return true;
    }
    
    // Approach 2: Backtracking recursion with memoization
    // O(n^2) 
    // O(n) recursion stack + memo table
    // memoization table. -1 means unknown, 0 means this position can't reach last index
    // 1 means this position can reach last index;
    int[] memo;
    
    public boolean canJump(int[] nums) {
        memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            memo[i] = -1;
        }
        // initialize last index as 1
        memo[nums.length - 1] = 1;
        return recur(0, nums);
    }
    
    private boolean recur (int position, int[] nums) {
        // base case
        if (position == nums.length - 1) return true;
        // check memo table 
        if (memo[position] == 0) return false;
        else if (memo[position] == 1) return true;
        
        // not in memo table, we do our recursion once more
        else {
            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            for (int i = position+1; i <= furthestJump; i++) {
                if (recur(i, nums)) return true;
            }
            
            return true;
        }
    }
    
    // Approach 3: DP from the back
    // O(n^2)
    // O(n)
    public boolean canJump(int[] nums) {
        // same dp table 
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        dp[nums.length - 1] = 1;
        
        // starting from the back, check if positions can be reached
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestStep = Math.min(i + nums[i], nums.length - 1);
            for (int j = i+1; j <= furthestStep; j++) {
                if (dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        
        return dp[0] == 1;
    }
    
    // Approach 4: greedy
    // As we see in approach 3, if we meet the best case we only need o(1) per each iteration
    // This approach is the simplest but very hard to come up with in an interview, can skip
    // O(n)
    // O(1)
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        
        return lastPos == 0;
    }
}