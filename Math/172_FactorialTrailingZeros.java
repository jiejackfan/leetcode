import java.math.BigInteger;

class Solution {
    
    // Approach 1: Brute force (TLE)
    // More than O(n^2)
    // O(nlogn) bits needed for n! storage
    // calculate factorial and count 0
    public int trailingZeroes(int n) {
        // calculate n! with BigInteger because long and int wont fit
        BigInteger nFac = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFac = nFac.multiply(BigInteger.valueOf(i));
        }
        
        // count 0s of this nFac number
        int zeroCount = 0;
        // while we see a trailing 0 by MODing, we add 1 to zeroCount
        while (nFac.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFac = nFac.divide(BigInteger.TEN);
            zeroCount++;
        }
        
        return zeroCount;
    }
    
    // Approach 2: Counting Factors of 5 (TLE)
    // O(n)
    // O(1)
    // To count 0 is counting 10 which is 2*5, since 2 appears more than 5, we only need to count how many 5 there are in n!
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        
        // for every 5 number, count how many factors of 5 it contains
        for (int i = 5; i < n; i+=5) {
            int pow5 = 5;
            while (i % pow5 == 0) {
                zeroCount++;
                pow5 *= 5;
            }
        }
        return zeroCount;
    }
    
    // Approach 3: Counting Factor of 5 Efficient
    // simplify the logic from approach 2, we want to find how many powers of 5 this n can fit and for each power how many zeros there are
    public int trailingZeroes(int n) {
         int zeroCount = 0;
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n/currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }
}