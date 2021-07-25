// 7/25/2021

class Solution {
    // Approach 1: brute force
    // O(n^3)
    // O(1)
    // double for loop to check every interval
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                int sum = 0;
                // find the sum of this interval subarray
                for (int h = i;h < j; h++) {
                    sum += nums[h];
                }
                if (sum == k)
                    ans++;
            }
        }
        return ans;
    }
    
    
    // Approach 2: Without space
    // For each sum, find all of its sums 
    // O(n^2)
    // O(1)
    public int subarraySum(int[] nums, int k) { 
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) 
                    count++;
            }
        }
        return count;
    }
    
    // there is another hashtable solution that has time complexity O(n), but I don't understand
}