// 8/14/2021
class Solution {
    
    // Approach 1: Finding Index using 2 loop
    // O(n)
    // O(1)
    // Starting from the back, find the location of last index of last word
    // then count how long this last word is from the back
    public int lengthOfLastWord(String s) {
        // trim the trailing spaces
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }
        // p now is ponting at the last char of the last word
        
        // compute the length of last words
        int length = 0;
        while (p >= 0 && s.charAt(p) != ' ') {
            p--;
            length++;
        }
        
        return length;
    }
    
    // Approach 2: Finding index using 1 loop
    public int lengthOfLastWord(String s) {
        int p = s.length() - 1, length = 0;
        while (p >= 0) {
            if (s.charAt(p) != ' ') {
                length++;
            }
            else if (length > 0) {
                return length;
            }
            p--;
        }
        return length;
    }
    
    // Approach 3: Built-in String function
    // using trim, lenght, lastIndexOf API functions
    public int lengthOfLastWord(String s) { 
        s = s.trim(); // remove ending white space
        return s.length() - s.lastIndexOf(" ") - 1;
    } 
    
}    