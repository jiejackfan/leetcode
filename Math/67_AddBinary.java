import java.math.BigInteger;

class Solution {
    
    // Approach 1: Bit by Bit Computation
    // O(max(m, n))
    // O(max(m, n))
    public String addBinary(String a, String b) {
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        
        while (p1 >= 0 || p2 >= 0) {
            int d1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int d2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            
            carry += (d1 + d2);
            if (carry % 2 == 1)
                res.append('1');
            else 
                res.append('0');
            
            carry /= 2;
            p1--;
            p2--;
        }
        
        if (carry == 1) 
            res.append('1');
        
        return res.reverse().toString();
    }
    
    
    // Approach 2: Bit Manipulation
    // O(n + m)
    // O (max(n, m))

    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        
        // while y != 0
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        
        return x.toString(2);
    }
}