// 07/21/2021
// Amazon OA 2
class Solution {
    
    // Greedy Algorithm
    // O(nlogn) ==> adding n elements to pq is O(nlogn) / iteration n steps will also be O(nlogn)
    // O(n) n elements in pq
    
    // ** Add/remove operations in pq cost O(logn)
    
    // Always pick the smallest two sticks to add, this is because the sticks selected early will appear more in total cost
    // compared to sticks selected later. Use priority queue (min heap) as it stores from small to big/
    public int connectSticks(int[] sticks) {
        int result = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        // add all sticks into pq
        for (int stick : sticks) {
            pq.add(stick);
        }
        
        // start iterating and calculate result
        while (pq.size() > 1) {
            // obtain the 2 shortest sticks
            int stick1 = pq.remove();
            int stick2 = pq.remove();
            
            // add the cost of this iteration to total cost
            int cost = stick1 + stick2;
            result += cost;
            
            // add this new stick into pq
            pq.add(cost);
            
        }
        
        return result;
    }
}