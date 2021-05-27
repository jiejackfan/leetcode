// May 27, 2021
class Solution {
    // brute force
    // first square every element and use built-in sort to sort result
    // O(nlogn) Sorting takes nlogn time
    // O(logn) Java built in array sort uses quicksort which requires logn space.
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    
    // Two pointer:
    // Have left pointer point at the beginning, right pointer point at the end
    // Traverse from back of result, add left/right pointer based on their absolute value
    // O(n)
    // O(n)
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n-1;
        
        for (int i = n-1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}