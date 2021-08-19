// 8/18/2021
class Solution {
    // Approach 1: Right to left
    // Use the fomula provided below, start reading 1 char at a time from the right
    // O(n)
    // O(1)
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        // build 1 character's map and put in the 26 aphabet and their matching digit
        Map<Character, Integer> alpha_map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            // capital 'A' is number 65 in the ASCII table
            int c = i + 65;
            alpha_map.put((char) c, i+1);
        }
        
        // start iterating from the back, read one character at a time and apply this formula
        // value = value of single * 26 ^ ith position from the right (0-indexed)
        int n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            //get this character
            char cur = columnTitle.charAt(n - 1 - i);
            // calculate and add to result
            result += alpha_map.get(cur) * Math.pow(26, i);
        }
        return result;
    }
    
    // Approach 2: Left to right
    // O(n)
    // O(1)
    // follows the normal base 10 calculation val * 10 + curVal
    // starts from the left and no more hashtable to store key val
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            result = result * 26;
            result += (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}