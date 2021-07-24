// 7/24/2021

class Solution {
    
    // Approach 1: Sort and find max width/height
    // The maximum cake area is equal to max width * max height
    // find the max width and max height seperately
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // sort cuts because the order is not small to big
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        
        // find the maximum, initialize as the sides first and iterate to find max in the middle
        // use long data type to prevent overflow
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for (int i = 1; i < n; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        // find max width
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < m; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i-1]);
        }
        
        return (int) ((maxHeight * maxWidth) % 1000000007);
    }
}