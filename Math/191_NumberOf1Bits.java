public class Solution {
    // you need to treat n as an unsigned value
    // Approach 1: loop and flip using a bit mask
    // O(1) a for loop of size 32
    // O(1)
    // Go bit by bit, AND with a bit mask to see if this bit is a 1
    public int hammingWeight(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            // need this extra parenthesis so AND operation comes first
            if ((n & mask) != 0) {
                ans++;
            }
            mask <<= 1;
        }
        return ans;
    }
    
    // Approach 2: bit manipulation trick
    // if we do n & (n-1) we can eliminate the right most 1.
    // we loop until we eliminated all 1s.
    public int hammingWeight(int n) {
        int ans = 0;
        
        while (n != 0) {
            ans++;
            n &= (n-1);
        }
        
        return ans;
    }
    
}