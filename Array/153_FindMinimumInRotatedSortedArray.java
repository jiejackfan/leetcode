// 6/24/2021
class Solution {
    // binary search solution
    // Define left, right and mid for binary search. Update mid until we find a place where the sequence of number
    // changes from a big to small number. 
    // O(logn)
    // O(1)
    public int findMin(int[] nums) {
        int n = nums.length;
        
        if (n == 1) return nums[0];
        
        int left = 0, right = n - 1;
        
        // if this nums array is sorted from min to max already
        if (nums[left] < nums[right]) return nums[0];
        
        // start of binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // check if we have reached the answer location
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            
            // not yet at locations, search in smaller range
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}