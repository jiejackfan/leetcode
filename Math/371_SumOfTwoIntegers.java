// 6/25/2021

class Solution {
    // Bit manipulation 
    public int getSum(int a, int b) {
        int x = Math.abs(a), y = Math.abs(b);
        
        // ensure abs(a) is always greater than abs(b)
        if (x < y) return getSum(b, a);
        
        // save the sign of the answer result
        int sign = a > 0 ? 1 : -1;
        
        // sum of 2 positive integers
        if (a * b > 0) {
            // while carry is non zero
            while (y != 0) {
                // XOR calculates answer with carry, && + shift 1 calculates carry only
                int ans = x ^ y;
                int carry = (x & y) << 1;
                x = ans;
                y = carry;
            }    
        }
        // difference of 2 positive integers
        else {
            // while borrow is non zero
            while (y != 0) {
                // XOR calculates answer with carry, && + shift 1 calculates borrow only
                int ans = x ^ y;
                int borrow = ((~x) & y) << 1;
                x = ans;
                y = borrow;
            }
        }
        
        // remember to return the sign as well
        return x * sign;
    } 
}