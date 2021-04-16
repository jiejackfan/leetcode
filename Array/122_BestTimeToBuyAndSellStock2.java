// April 16, 2021

class Solution {
    // brute force recursion
    // For every price drop, we recur on the latter part to find max price drop of the latter part. 
    // All recursion added together will give us the max profit.
    // O(n^n) total times the recursion function will be called.
    // O(n) recursion stack
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }
    
    public int calculate(int prices[], int s) {
        if (s >= prices.length) return 0;
        
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxFromS = 0;
            for (int i = start+1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i+1) + prices[i] - prices[start];
                    if (profit > maxFromS) maxFromS = profit;
                } 
            }
            if (maxFromS > max) max = maxFromS;
        }
        return max;
    }
    
    
    // Peak Valley Approach
    // O(n), O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        int i = 0;
        int peak = 0;
        int valley = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i+1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i+1]) i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        
        return maxProfit;
    }
    
    // Simple one pass
    // O(n) O(1)
    // Instead of finding peak and valley, just record everytime we see an increase in profit between 2 days.
    public int maxProfit(int[] prices) { 
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]) {
                maxProfit += prices[i+1] - prices[i];
            }
        }
        return maxProfit;
    }
}