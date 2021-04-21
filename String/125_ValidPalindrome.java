// April 20, 2021

class Solution {
    // Two pointer
    // O(n) O(1)
    // Go fron outside to inside, check left and right characters are equal
    // ignore the non character case and remember to lower case the characters as well.
    // Used Character.isLetterOrDigit() and Character.toLowerCase()
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int left = 0, right = n - 1;
        
        for (left = 0, right = n - 1; left < right; left++, right--) {
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) return false;
        }
        
        return true;
        
    }
}