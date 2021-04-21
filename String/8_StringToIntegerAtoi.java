// April 21, 2021

class Solution {
    // Scan from left to right. No algorithm used
    // O(n) O(1)
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int result = 0;
        
        // delete white spaces
        while (i < s.length() && s.charAt(i) == ' ') i++;
        
        // find out sign of this number
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) 
            sign = s.charAt(i++) == '+' ? 1 : -1;
        
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE/10 || 
                (result == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > Integer.MAX_VALUE%10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + s.charAt(i++) - '0';
        }
        
        return result * sign;
    }
}