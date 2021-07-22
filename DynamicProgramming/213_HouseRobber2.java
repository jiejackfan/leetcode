class Solution {
    // Approach 1: DP w/o table
    // O(n)
    // O(1)
    // Similar logic with house robber except first and last house can't be together
    // Therefore, seperate the problem into problem containing house 0 to 2nd to last AND house 1 to last
    public int rob(int[] nums) {
        // edge case of when there is no house or just 1 house
        if (nums.length == 0) return 0;
        
        if (nums.length == 1) return nums[0];
        
        int max1 = rob(nums, 0, nums.length - 2);
        int max2 = rob(nums, 1, nums.length - 1);
        
        return Math.max(max1, max2);
    }
    
    // helper to solve simple house rubber problem 
    private int rob(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = t1;
            int current = nums[i];
            t1 = Math.max(t1, t2 + current);
            t2 = temp;
        }
        
        return t1;
    }
    
}