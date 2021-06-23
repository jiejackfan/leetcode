class Solution {
    // Intuition: find the product of array except self by dividing the total product by nums[i].
    // problem contraint is we can't use division.
    
    // Approach: left & right product list
    // O(n)
    // O(n)
    // Create left and right array, at each index store the product of every element before/after the index
    // Use the two arrays to find "product of array except self"
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // create left array
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        
        // create right array from right to left
        int[] right = new int[n];
        right[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        
        // calculate answers
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
    
    // Constant space solution
    // similar to previous approach, however, no left/right array. Create ans array that acts like the left array.
    // right array will be represented by a variable instead.
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        
        return ans;
    }
}