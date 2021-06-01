// May 31, 2021


class Solution {
    // brute force
    // go through every pairing and record the maximum water
    // O(n^2)
    // O(1)
    public int maxArea(int[] height) {
        int ans = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                ans = Math.max(ans, area);
            }
        }
        
        return ans;
    }
    
    // Two pointer
    // Pointer at each end, move the shorter stick (the limiting stick) inwards to find maximum area
    // O(n)
    // O(1)
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(area, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}