class Solution {
    // Approach 2 : pq
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int i = 0, res = 0, maxDistance = startFuel;
        while (maxDistance < target) {
            while (i < stations.length && stations[i][0] <= maxDistance) {
                pq.offer(stations[i++][1]);
            }
            if (pq.isEmpty())
                return -1;
            maxDistance += pq.poll();
            res++;
        }
        return res;
    }
}