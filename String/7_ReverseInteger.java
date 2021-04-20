// April 20, 2021

class Solution {
    
    // Push and Pop
    // O(logx) O(1)
    // 32 bit integer range from -2147483648 to 2147483647
    // can be represented as Integer.MIN_VALUE and Integer.MAX_VALUE
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        } 
        return rev;
    }
}