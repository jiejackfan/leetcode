//10/01/2021
// Didn't implement DP solution because no comment and not interested...

class Solution {
    
    // Approach 1: Recursion
    // Most logical solution
    // O((T+P) * 2 ^(T+P/2))
    // O(T^2 + P^2)
    public boolean isMatch(String s, String p) {
        // base case: if the pattern and string are both empty, we know this expression is true
        if (p.isEmpty())
            return s.isEmpty();
        
        // find out whether the first character matches
        boolean firstChar = (!s.isEmpty() && 
                                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));  
            
        // if second char is a *, we check if we need to skip current char+* 
        // or we use char+* for more characters
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) ||
                    (firstChar && isMatch(s.substring(1), p)));
        }
        
        // else, we just check if next char of p and s is the same recursively
        else {
            return (firstChar && isMatch(s.substring(1), p.substring(1)));
        }
    }
}