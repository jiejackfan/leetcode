// 8/5/2021

class Solution {
    
    // Greedy 1 pass solution
    // O(n)
    // O(1)
    // Car can travel a circuit under 2 conditions
    // 1: total gas - sum should be greater than equal to 0 to finish 1 loop from any starting position
    // 2: steps after starting position to 0th position must be >= 0 
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        
        for (int i = 0; i < n; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            
            // if one couldn't get there
            if (curr_tank < 0) {
                starting_station = i + 1;
                curr_tank = 0;
            }
        }
        
        return total_tank >= 0 ? starting_station : -1;
    }
}