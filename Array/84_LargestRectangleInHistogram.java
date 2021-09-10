class Solution {
    // Approach 1: Brute force
    // O(n^3)
    // O(1)
    // For every pair of rectangle ranges (i ~ j), pick out the shortest block
    // and find the area. Record and return the largest area
//     public int largestRectangleArea(int[] heights) {
//         int ans = 0;
        
//         // double for loop to loop through all different combinations of rectangles
//         for (int i = 0; i < heights.length; i++) {
//             for (int j = i; j < heights.length; j++) {
//                 // find the limiting block 
//                 int limit = Integer.MAX_VALUE;
//                 for (int k = i; k <= j; k++) {
//                     limit = Math.min(limit, heights[k]);
//                 }
//                 ans = Math.max(ans, limit * (j - i + 1));
//             }
//         }
//         return ans;
//     }
    
    // Approach 3: Divide and Conquer
    // O(nlogn) or O(n^2) worst case
    // O(n)
    public int calculateArea(int[] height, int start, int end) {
        if (start > end) 
            return 0;
        int minIndex = start;
        // find the min index within range start and end
        for (int i = start; i <= end; i++) {
            if (height[minIndex] > height[i])
                minIndex = i;
        }
        return Math.max(height[minIndex] * (end - start + 1),
                        Math.max(calculateArea(height, start, minIndex - 1),
                                calculateArea(height, minIndex +1, end)));
    }
    
    public int largestRectangleArea(int[] height) {
        return calculateArea(height, 0, height.length - 1);
    }
}