// March 31, 2021
// tag: array, binary search

class Solution {
    // One pass binary search:
    // O(log n) binary search, O(1)
    // Binary search, the difference is we check how the array is ordered.
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;

            // if the left part of the nums array is not rotated
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }

            // if the left of the array is rotated
            else {
                // if the target is on the right side
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid+1;
                }
                else {
                    end = mid - 1;
                }
            }
        } 
        
        return -1;
    }
}