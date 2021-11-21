class Solution {
    // Approach 1: Brute force (TLE)
    // Double for loop O(n^2) O(n)
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i+1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0)
                    ans++;
            }
        }
        return ans;
    }
    
    // Approach 2： Array store frequency
    // Can simplify into 2 rules:
    // either 1. a%60 == 0 && b%60 == 0
    // or 2. a%60 = 60 - b%60
    // Then go thru array once to store remainder and increase countif the current a satisfies one
    // of the above conditions.
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            }
            else { // check if a%60 = 60 - b%60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return count;
    }
}