// 8/14/2021
class Solution {
    
    // Approach 1: Binary Search
    // Pivot finding using binary search
    // O(logn)
    // O(1)
    public int mySqrt(int x) {
        if (x < 2) return x;
        
        long num;
        int pivot, left = 2, right = x / 2;
        
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot; //prevent integer overflow
            if (num > x)
                right = pivot - 1;
            else if (num < x)
                left = pivot + 1;
            else
                return pivot;
        }
        
        return left;
    }
    
    // Approach 2: recursion and bit shift
    // sqrt(x) = 2 * sqrt(x/4)
    // sqrt(x) = sqrt(x >> 2) << 1
    public int mySqrt(int x) { 
        // base case : if x < 2 then return x;
        if (x < 2) 
            return x;
        
        // use formula to do recursion. Check this result with result + 1 to see which is the correct version
        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        
        //
        return (long) right * right > x ? left : right; //prevent integer overflow
    }
}