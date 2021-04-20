// April 19, 2021

class Solution {
    public void reverseString(char[] s) {
        // two pointers
        // O(n/2) O(1)
        int n = s.length;
        int i = 0, j = n - 1;
        while(i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }
}