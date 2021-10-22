class Solution {
    // Approach 1: Two Pointers
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        
        while (left < right) {
            // update the side with less height first
            // update left side
            if (height[left] < height[right]) {
                // if the current height is higher than max, update max
                // if the max is higher, add to answer
                if (height[left] >= left_max)
                    left_max = height[left];
                else 
                    ans+= (left_max - height[left]);
                left++;
            }
            // update right side
            else {
                // if the current height is higher than max, update max
                // if the max is higher, add to answer
                if (height[right] >= right_max)
                    right_max = height[right];
                else 
                    ans += (right_max - height[right]);
                right--;
            }
        }
        
        return ans;
    }
}