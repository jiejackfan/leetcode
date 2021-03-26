class Solution {
    // brute force: O(n^3) O(1)
    // Sort of like sliding window, this time the window is a substring instead of index
    // Go through all possible word combinations. Call helper function to check whether string
    // is a palindrome.
    public String longestPalindrome(String s) {
        int length = 0;
        String answer = "";
        if (s.length()==1) return s;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if(isPalindromic(s.substring(i, j))) {
                    if (j-i > length) {
                        length = j-i;
                        answer = s.substring(i, j);
                    }
                    
                }
            }
        }
        return answer;
    }
    
    public Boolean isPalindromic(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
    
    // Expand aroud center: O(n^2) O(1)
    // Go through each character, find palindrome with this character as center
    // Handle the cases of odd and even palindrome
    
    public String longestPalindrome(String s) {
        int length = 0;
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            //check odd palindrome
            int oddLength = expandAroundCenter(s, i, i);

            //check even palindrome
            int evenLength = expandAroundCenter(s, i, i+1);
            
            int temp = Math.max(oddLength, evenLength);
            if (temp > length) {
                length = temp;
                // take substring
                answer = s.substring((i - (temp-1)/2), i + (temp)/2 +1);
            }
        }
        return answer;
    }
    
    // Helper to return the length of this palindrome
    public int expandAroundCenter(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // because last iteration fails, we take length - 2
        return right - left - 1;
    }
}