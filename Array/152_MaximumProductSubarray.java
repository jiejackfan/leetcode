class Solution {
    // brute force
    // O(n^2)
    // O(1)
    // find i and j in 2 for loop and calculate the subarray product. Use Math.max to find the maximum subarray
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            int acu = 1;
            for (int j = i; j < n; j++) {
                acu *= nums[j];
                max = Math.max(acu, max);
            }
        }
        return max;
    }
    
    
    // dynamic programming
    // O(n)
    // O(1)
    // Have three different variables to find the max of every combo. This needs to be revisited to understand why. 
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int ans = maxSoFar;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            int temp_max = Math.max(cur, Math.max(maxSoFar * cur, minSoFar*cur));
            minSoFar = Math.min(cur, Math.min(maxSoFar * cur, minSoFar * cur));
            maxSoFar = temp_max;
            ans = Math.max(maxSoFar, ans);
        }
        return ans;
    }
}