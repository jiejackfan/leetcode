class Solution {
    
    // Approach 1: Find word and reverse
    // Use 2 String Builders. One for answer, one for individual word
    // Go thru each char, save a word until space, and we reverse the current word to add to ans
    // repeat the process.
    // O(n) O(n)
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            // if not a empty, continue building current word
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            }
            // else reverse the string, add to answer and reset word
            else {
                ans.append(word.reverse());
                ans.append(' ');
                word.setLength(0);
            }
        }
        
        // add the last word
        ans.append(word.reverse());
        return ans.toString();
    }
}