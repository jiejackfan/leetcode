// 7/22/2021
class Solution {
    // Approach 1: linear search
    // O(n)
    // O(1)
    // search one element at a time, 
    // peak element will always be bigger than its right neighbor 
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] > nums[i+1]) 
                return i;
        }
        return n-1;
    }
    
    // Approach 2: recursive binary search
    // O(logn)
    // O(logn)
    // if mid is greater than right neighbor, search left half
    // if mid is less than right neighbor, search right half
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    
    private int search(int[] nums, int left, int right) {
        if (left == right) 
            return left;
        
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid+1]) {
            return search(nums, left, mid);
        } else {
            return search(nums, mid + 1, right);
        }
    }
    
    // Approach 3: iterative binary search
    // O(n)
    // O(1)
    // same as approach 2 but iterative with constant space
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else 
                l = mid + 1;
        }
        
        return l;
    }
}