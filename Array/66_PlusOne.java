// April 18, 2021


class Solution {
    // Schoolbook addition with carry
    // O(n) one pass runtime
    // O(n+1) worst case when need to allocate space for new array
    // One of three situation: start from last number in array
    // 1. last digit is less than 9, add to last number and return.
    // 2. last digit is 9, change to 0 and add 1 to the number on the left.
    // 3. all digits are 9, allocate new space for array n+1 and assign first element as 1.
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
        
        // here all numbers are 0, need to append 1 to the front of array
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }
}