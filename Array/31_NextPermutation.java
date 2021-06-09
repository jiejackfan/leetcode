// June 9
// In los angeles

class Solution {
    // Single pass approach
    // start from right to left to find the first decreasing element
    // start from right to left to find the element just 1 greater than the first decreasing element 
    // O(n)
    // O(1)
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        while (i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        // this is for when the starting nums[] is in full reverse order
        reverse(nums, i+1);
    } 
    
    // helper to swap 2 elements
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
    // helper to reverse all numbers from the start index
    // two pointer approach 
    // O(n)
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}