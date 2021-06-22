// 6/22/2021

class Solution {
    
    // Approach Use array index as hash key
    // O(n)
    // O(1)
    // Following the steps outlined below. 
    public int firstMissingPositive(int[] nums) {
        // check if 1 is present in nums
        int n = nums.length;
        int contains = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0) return 1;
        
        // clean up data: replace negative, zero, and numbers larger than n with the number 1.
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        
        // Walk along array. Change the sign of ath element if you meet number a. Be careful of duplicates.
        // need to use Math.abs to account for the negative number
        for (int i = 0; i < n; i++) {
            int cur = Math.abs(nums[i]);
            if (cur == n) {
                nums[0] = - Math.abs(nums[0]);
            }
            else {
                nums[cur] = - Math.abs(nums[cur]);
            }
        }
        
        // Find the answer
        // first loop through index 1 to n-1, then check index 0. If all are negative, the final answer is n+1
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }
        
        if (nums[0] > 0) return n;
        
        return n+1;
    }
}