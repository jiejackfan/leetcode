class Solution {
    public boolean isPalindrome(int x) {
        // check unit digit is 0, and number is not negative
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reverse = 0;
        int digit = 0;
        while (x > reverse) {
            digit = x % 10;
            reverse = reverse * 10 + digit;
            x /= 10;
        }
        
        
        return reverse == x || x == reverse / 10;
    }
}
