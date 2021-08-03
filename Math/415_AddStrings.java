// 8/2/2021

class Solution {
    // Approach 1: Addition problem with strings as input variable
    // O(max(n, m))
    // O(max(n, m))
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        
        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        
        while (p1 >= 0 || p2 >= 0) {
            // find current number to add
            int d1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int d2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            
            // find the value and carry
            int value = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            
            // append to answer and reset pointer
            res.append(value);
            p1--;
            p2--;
        }
        
        // check extra carry
        if (carry != 0) 
            res.append(carry);
        
        // need to reverse
        return res.reverse().toString();
    }
}