// April 19, 2021
// May 10, 2021

class Solution {
    // two pointers
    // O(n/2) O(1)
    public void reverseString(char[] s) {
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


    // May 10 2021
    // recursion lesson card
    // O(n/2) 
    // O(n) recursion stack
    public void reverseString(char[] s) {
        swap(s, 0, s.length - 1);
    }    
    public void swap(char[] s, int left, int right) {
        if (left > right) return;
        
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        
        swap(s, left, right);
    }
}