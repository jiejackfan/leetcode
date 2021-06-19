// 06/17/2021
class Solution {
    
    // Brute force version just does a linear scan. Record the first and last positions that an element
    // appears. Time complexity is O(n) but does not use the sorted criteria.
    
    
    
    // Binary Search Solution
    // O(logn)
    // O(1)
    // Use binary search to find the first and last occurance seperately
    public int[] searchRange(int[] nums, int target) {
        // find first occurance
        int firstOccurance = this.findBound(nums, target, true);
        
        // if no occurance found, return -1, -1
        if (firstOccurance == -1) return new int[]{-1, -1};
        
        // find last occurance
        int lastOccurance = this.findBound(nums, target, false);
        
        // return ans
        return new int[]{firstOccurance, lastOccurance};
    }
    
    // binary search helper function
    // O(logn)
    // O(1)
    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;
        
        // loop for each search iteration
        while (begin <= end) {
            // find middle index
            int mid = begin + (end - begin) / 2;
            
            // if the target in found as the middle, check based on whether it is the first/last occurance
            if (nums[mid] == target) {
                
                // if looking for first occurance, if mid is at begin OR previous element is not target then we found the first occurance
                // else change end to find first occurance
                if (isFirst) {    
                    if (mid == begin || nums[mid-1] != target) 
                        return mid;
                    end = mid - 1;
                }
                
                // if looking for last occurance, if mid is at end OR next element is not target then we found the last occurance
                // else change begin to find last occurance
                else{
                    if (mid == end || nums[mid+1] != target)
                        return mid;
                    begin = mid + 1;
                }
            }
            
            // if target is less than current mid, target is in the first half
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            
            // if target is greater than current mid, target is in the right half
            else if (nums[mid] < target) {
                begin = mid + 1;
            }
        }
        
        // did not find target, return -1
        return -1;
    }
    
}