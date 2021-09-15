// 09/15/2021
class Solution {
    // Approach 1: Binary Search
    // Using the binary search frame. Return either left/right for if we don't find target but is
    // at the target position
    // O(logn) O(1)
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}