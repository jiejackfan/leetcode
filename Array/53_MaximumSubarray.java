// April 11, 2021
// tag: Array, Maximum subarray, Dynamic programming, Divide and conquer
class Solution {
    // Brute force 
    // No need time complexity O(n^3) solution, can be done with O(n^2)
    // O(1)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int maxSoFar = 0;
            for (int j = i; j < nums.length; j++) {
                maxSoFar += nums[j];
                maxSum = Math.max(maxSoFar, maxSum);
            }
        }
        return maxSum;
    }
    
    // DP
    // O(n), O(1)
    // When a subarray sum is negative we know its not worth keeping anymore. Any more element adding to this subarray
    // will not be largest subarray.
    // 
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // currSum += nums[i];
            // if (currSum < 0) {
            //     if (nums[i] < 0) currSum = 0;
            //     if (nums[i] >= 0) currSum = nums[i];
            // }
            int num = nums[i];
            currSum = Math.max(num, currSum + num);
            maxSum = Math.max(currSum, maxSum);
        }
        
        return maxSum;
    }
    
    // Divide and Conquer
    // O(n logn) recursion will be called logn times, each time we recur on every element
    // O(logn) stores recursion stack
    // Start from middle, determine the best subarray that includes the middle element.
    // Recur on the left and right part of array to find the best subarray of their middle.
    int[] numsArray;
    public int maxSubArray(int[] nums) {
        numsArray = nums;
        return findBestSubarray(0, numsArray.length - 1);
    }
    
    public int findBestSubarray(int left, int right) {
        // base case to stop recursion:
        if (left > right) return Integer.MIN_VALUE;
        
        int leftSum = 0;
        int rightSum = 0;
        int curr = 0;
        int mid = Math.floorDiv(left + right, 2);
        
        // find out the combined sum with middle element
        for (int i = mid-1; i >= left; i--) {
            curr += numsArray[i];
            leftSum = Math.max(curr, leftSum);
        }
        curr = 0;
        for (int i = mid+1; i <= right; i++) {
            curr += numsArray[i];
            rightSum = Math.max(curr, rightSum);
        }
        int bestCombined = numsArray[mid] + leftSum + rightSum;
        
        //recur to find out best sum on left and right subarray
        int leftHalf = findBestSubarray(left, mid-1);
        int rightHalf = findBestSubarray(mid+1, right);
        
        return Math.max(bestCombined, Math.max(leftHalf, rightHalf));
    }
}