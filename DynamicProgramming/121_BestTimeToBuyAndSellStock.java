// April 10, 2021

class Solution {
    // brute force
    // O(n^2) O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int earning = prices[j] - prices[i];
                if (earning > maxProfit) maxProfit = earning;
            }
        }
        return maxProfit;
    }
    
    // One pass
    // O(n) O(1)
    // Greedy algorithm approach, not actually dynammic programming
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }
        
        return maxProfit;
    }
}