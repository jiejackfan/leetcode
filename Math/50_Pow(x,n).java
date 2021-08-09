class Solution {
    // Math problem !!!!
    
    // Approach 1: Brute force
    // O(n)
    // O(1)
    // TLE answer, if n is huge then can't compute
    // multiply number x by itself for N times
    public double myPow(double x, int n) {
        long N = n;
        
        // if pow (n) is negative, then we change x to 1/x and make n positive
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        
        double ans = 1;
        for (int i = 0; i < N; i++) {
            ans *= x;
        }
        
        return ans;
    }
    
    // Approach 2: Fast Power Algorithm Recursive
    // Use a special property of power to reduce power computation
    // (1 ^ (n ^ 2)) = (1 ^ 2n)
    // O(log n)
    // O(log n) recursion stack
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        // base case: if we reach the end, start computing the ans on the way back
        if (n == 0) 
            return 1.0;
        
        double half = fastPow(x, n/2);
        
        // if n is even, we know answer is half * half
        if (n % 2 == 0) 
            return half * half;
        // if n is odd, we need to multiply an x for the extra 1 n at the end
        else 
            return half * half * x;
    }
    
    
    // Approach 3 : Fast power iterative solution
    // Similar to approach 2 but iterative way of solving it
    // O(logn)
    // O(1)
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
     }
}