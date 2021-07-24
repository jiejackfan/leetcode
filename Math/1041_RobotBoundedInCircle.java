// 07/23/2021

class Solution {
    
    // Approach: 1 pass
    // O(n)
    // O(1)
    // Proofed: the trajectory will be bounded if it is a limit cycle trajectory
    // after 1 cycle, the traj is a limit cycle traj if
    // 1. it returns to the starting point
    // 2. its direction is not facing north
    public boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // initial position in the center
        int x = 0, y = 0;
        int idx = 0; // facing north
        
        for (char i : instructions.toCharArray()) {
            if (i == 'L') 
                idx = (idx + 3) % 4;
            else if (i == 'R') 
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }
        
        // after one cycle, time to determin if traj is a limit cycle trajectory
        return (x== 0 && y == 0) || (idx != 0);
    }
}