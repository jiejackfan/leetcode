// 6/26/2021

class Solution {
    // brute force jack solution
    // Double for loop to search through all combinations
    // O(n^2) O(1)
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            boolean isPresent = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) isPresent = true;
            }
            if (!isPresent) return i;
        }
        return -1;
    }
    
    // Approach 1: sort
    // Sort the array so we can find if element equals previous + 1.
    // Need to check special case of last and first element.
    // O(nlogn) sorting time
    // O(n) storing array
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // ensure last index is equal to n+1 and first index is equal to 0
        if (nums[n-1] != n) return n;
        if (nums[0] != 0) return 0;
        
        // check elements 1 to n-1 through to find answer
        for (int i = 1; i < n; i++) {
            int expected = nums[i - 1] + 1;
            if (nums[i] != expected) return expected;
        }
        
        return -1;
    }
    
    // Approach 2: XOR correct answer with all element
    // O(n)
    // O(1)
    // XOR of 2 identical number is 0, if we XOR all 0-n with all elements in nums, we are left with the missing number
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= (i ^ nums[i]);
        }
        return missing;
    }
    
    // Approach 3 : Gauss Formula
    // O(n)
    // O(1)
    // Gauss formula of sum from 0 to n is n*(n+1)/2. We will use this sum to subtract the sum of all elements in nums to find the missing
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num: nums) actualSum += num;
        return sum - actualSum;
    }
    
}