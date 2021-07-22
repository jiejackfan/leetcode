// 7/18/2021

public class Solution {
    // you need treat n as an unsigned value
    
    // Approach 1: shift and add 
    // Bit by bit which requires a for loop
    // O(1)
    // O(1)
    // Shift result to the left while getting n's last bit
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        
        return result;
    }
    
    // Approach 2: Bit switch
    // O(1)
    // O(1)
    // switch 16 bits, then switch 8 bits, then 4, 2, 1 till every bit is switched
    // this approach does not use a loop.
    public int reverseBits(int n) { 
        n = (n >>> 16 | n << 16);
        n = ((n & 0xff00ff00) >>> 8) | (n & 0x00ff00ff) << 8;
        n = ((n & 0xf0f0f0f0) >>> 4) | (n & 0x0f0f0f0f) << 4;
        n = ((n & 0xcccccccc) >>> 2) | (n & 0x33333333) << 2;
        n = ((n & 0xaaaaaaaa) >>> 1) | (n & 0x55555555) << 1;
        
        return n;
    }
}