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
    
    // Approach 1: Two Pointers
    // Have left and right pointers, we compare their abs values to see which one we square first
    // after squaring we insert the new number into correct position of array
    // O(n) O(n)
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                ans[i] = nums[right] * nums[right];
                right--;
            }
            else {
                ans[i] = nums[left] * nums[left];
                left++;
            }
        }
        return ans;
    }
}