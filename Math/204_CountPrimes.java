//8/22/2021

class Solution {
    
    // Approach 1: Sieve of Eratosthenes
    // Put numbers in an array starting from 2 to n - 1. Find the smallest prime starting from 2 and change its
    // multiples (which are non-prime).
    // O(sqrt(n) * logn * logn)
    // O(n)     
    public int countPrimes(int n) {
        if (n < 2) 
            return 0;
        
        // boolean array to mark if a number is prime. Numbers are represented by their index, and if value is True means
        // number is prime, if value is False means number is not prime.
        boolean[] number = new boolean[n];
        for (int p = 2; p <= (int)Math.sqrt(n); ++p) {
            if (number[p] == false) {
                for (int j = p*p; j < n; j += p)
                    number[j] = true;
            }
        }
        
        // count the number of primes in this array starting from index 2
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (number[i] == false)
                ans++;
        }

        return ans;
    }
}