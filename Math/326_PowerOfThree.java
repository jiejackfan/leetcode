// 8/22/2021
class Solution {
    // Approach 1: Loop Iteration
    // Divide the number by 3 while its reminder is 0, and if th ending n==1 then we know this number is power of 3
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        
        while (n % 3 == 0)
            n /= 3;
        
        return n == 1;
    }
    
    // Approach 2: Integer Limitation
    // Since given input n is int, max number goes up to 2147483647, max power of 3 is 1162261467
    // dive 3^19 by n, if remainder is 0 means n is a power of 3
    public boolean isPowerOfThree(int n) { 
        return n > 0 && 1162261467 % n == 0;
    }
}