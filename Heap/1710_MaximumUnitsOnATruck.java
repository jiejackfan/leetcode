// 7/23/ 2021

class Solution {
    // Approach 1: greedy algorithm
    // O(n^2)
    // O(1)
    // Pick the box with most units and put into truck, and so on until the truck is filled.
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int remainingSize = truckSize;
        int result = 0;
        
        while (remainingSize > 0) {
            int maxUnitBoxIndex = findMaxBox(boxTypes);
            
            // if all boxes are used then we exit loop to return current result
            if (maxUnitBoxIndex == -1) 
                break;
            
            // else we add current box into truck and update remainingSize
            // calculate how many boxes we can put into current truck
            int boxCount = Math.min(remainingSize, boxTypes[maxUnitBoxIndex][0]);
            result += boxCount * boxTypes[maxUnitBoxIndex][1];
            remainingSize -= boxCount;
            
            // mark current box type unit to -1 so it will no longer be considered in helper
            boxTypes[maxUnitBoxIndex][1] = -1;
        }
        
        return result;
    }
    
    // return the box index that has the maximum unit
    // -1 means no more boxes left to put
    private int findMaxBox(int[][] boxTypes) {
        int maxIndex = -1;
        int maxUnit = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][1] > maxUnit) {
                maxUnit = boxTypes[i][1];
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
    
    // Approach 2: use max heap to keep track of box with most unit
    // O(nlogn) while loop go through n elements, each poll from queue is O(logn)
    // O(n) queue size
    public int maximumUnits(int[][] boxTypes, int truckSize) { 
        
        // priority queue that mimics a max heap structure
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)-> b[1]-a[1]);
        
        queue.addAll(Arrays.asList(boxTypes));
        
        int result = 0, remaining = truckSize;
        
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int boxCount = Math.min(remaining, top[0]);
            result += boxCount * top[1];
            remaining -= boxCount;
            if (remaining == 0)
                break;
        } 
        return result;
    }
}