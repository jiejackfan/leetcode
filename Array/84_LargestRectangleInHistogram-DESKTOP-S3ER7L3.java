// 10/3/2021

class Solution {
    // Approach 1: Brute force (TLE)
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
    
    // Approach 3: Divide and Conquer (TLE)
    // O(nlogn) or O(n^2) worst case
    // O(n)
//     public int calculateArea(int[] height, int start, int end) {
//         if (start > end) 
//             return 0;
//         int minIndex = start;
//         // find the min index within range start and end
//         for (int i = start; i <= end; i++) {
//             if (height[minIndex] > height[i])
//                 minIndex = i;
//         }
//         return Math.max(height[minIndex] * (end - start + 1),
//                         Math.max(calculateArea(height, start, minIndex - 1),
//                                 calculateArea(height, minIndex +1, end)));
//     }
    
//     public int largestRectangleArea(int[] height) {
//         return calculateArea(height, 0, height.length - 1);
//     }
    
    // Approach 5: Stack
    // Save height index into a stack. Calculate max height each time the current height is <= previous height.
    // O(n) loop over all elements once
    // O(n) stack storage
    public int largestRectangleArea(int[] heights) {
        // initialize stack (deque) and put -1 in as begin
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        
        for (int i = 0; i < length; i++) {
            // calculate max area if the current i height is <= previous height
            while ((stack.peek() != -1) 
                    && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            // push the next height into the stack
            stack.push(i);
        }
        
        // after iterating all heights, we have some left in our stack. process those leftovers
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        
        return maxArea;
    }
}