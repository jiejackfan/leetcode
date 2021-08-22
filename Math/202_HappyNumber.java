// 8/21/2021

class Solution {
    
    // Approach 1: Hashset
    // Calculate the next number, check if it is in a hashset of visited numbers
    // O(logn) number of digits
    // O(logn) hashset
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        // while this next number is not 1 or it is not seen before, then we calculate the next number
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    
    // helper to calculate the next number
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
    
    // Approach 2: Floyd's Cycle Finding Algo
    // similar to "detecting if a linked list has a cycle", we use the fast/slow runner technique
    // fast runner will travel 2 number and slow 1 number each move. If fast runner reaches 1, then theres no cycle.
    // if fast runner meets slow runner at the same number, then there is a cycle.
    // O(logn)
    // O(1)
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
    
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
    }
}