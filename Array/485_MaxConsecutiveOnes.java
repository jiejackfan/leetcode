// May 27, 2021

class Solution {
    // One pass to find the most consecutive 1s.
    // O(n)
    // O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;                
            }
            else {
                ans = Math.max(count, ans);
                count = 0;
            }
        }
        // need to update if the longest 1s is at the end
        ans = Math.max(count, ans);
        return ans;
    }
}