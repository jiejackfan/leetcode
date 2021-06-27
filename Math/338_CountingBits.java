// 6/26/2021

class Solution {
    
    // Approach 1: pop count
    // Loop through each number, and use method from 191 to count 1s for each number
    // O(nk) k operations to find 1s for n number
    // O(n) space to store value for each number
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            ans[i] = popCount(i);
        }
        return ans;
    }
    
    private int popCount(int num) {
        int ans = 0;
        for (ans = 0; num != 0; ans++) {
            num &= (num - 1);
        }
        return ans;
    } 
    
    // Approach 2: DP + Most Significant Bit
    // O(n)
    // O(n)
    // For binary numbers with the same bit count 0-1, 2-3, 4-7; the numbers of 1s increase by 1.
    // Each while loop loops over these ranges. Uses dynamic programming to calculate next answer.
    public int[] countBits(int num) {
        int [] ans = new int[num + 1];
        int i = 0, b = 1;
        ans[i] = 0; // default of array is 0. This is just to show steps.
        
        // calculates all answers from 0 to b
        while (b <= num) {
            // calculates from b to 2b
            while (i < b && i + b <= num) {
                ans[i+b] = ans[i] + 1;
                ++i;
            }
            i = 0; //reset i
            b <<= 1; // b = 2b
        }
        
        return ans;
    }
    
    // Approach 3: DP + Least Significant Bit
    // O(n)
    // O(n)
    // When dividing a number by 2, we can eliminate the LSB. Two ways of doing this. 
    public int[] countBits(int num) {
        int [] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            //ans[i] = ans[i >> 1] + (i & 1);
            ans[i] = ans[i & (i-1)] + 1;
        }
        return ans;
    }
}