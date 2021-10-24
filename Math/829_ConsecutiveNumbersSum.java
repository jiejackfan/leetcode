// 10/22/2021


class Solution {
    // Approach 1: Math Fomula
    // N = (x+1) + (x+2) + .... + (x+k)
    // N = kx + k(k+1)/2
    // x = (N/k) - (k+1)/2
    // O(logn) O(1)
    public int consecutiveNumbersSum(int n) {
        // to find number of x using x = (N/k) - (k+1)/2
        // 2 constraints: x >= 0 && x is integer
        int ans = 0;
        // first contraint x >= 0, so k <= Math.sqrt(2N + 1/4) - 1/2
        int upperLimit = (int)(Math.sqrt(2 * n + 1/4) - 1/2);
        
        for (int k = 1; k <= upperLimit; ++k) {
            // second constraint: x is integer
            if ((n- k * (k+1) / 2) % k == 0)
                ans++;
        }
        
        return ans;
    }
}