// 10/3 prep tiktok oa

class Solution {
    // BFS
    // Use queue to do BFS. 
    // Use set's unique property to determine if a position is legal or not
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int steps = 0, furthest = x + a + b;
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        // 0 = forward, 1 = backward
        q.offer(new Pair(0,0)); // direction & position
        
        // a set of forbidden positions
        Set<Pair<Integer, Integer>> seen = new HashSet<>(q);
        for (int pos : forbidden) {
            seen.add(new Pair(0, pos));
            seen.add(new Pair(1, pos));
            furthest = Math.max(furthest, pos + a + b);
        }
        
        while (!q.isEmpty()) {
            for (int sz = q.size(); sz > 0; sz--) {
                Pair<Integer, Integer> p = q.poll();
                int dir = p.getKey(), pos = p.getValue();
                
                // At position, return answer
                if (pos == x) {
                    return steps;
                }
                
                
                Pair<Integer, Integer> forward = new Pair<>(0, pos + a);
                Pair<Integer, Integer> backward = new Pair<>(1, pos - b);
                // add next forward position, 
                // seen.add() will return false if already in set
                if (pos + a <= furthest && seen.add(forward))
                    q.offer(forward);
                // add backward step
                // prevents double backward
                if (dir == 0 && pos - b >= 0 && seen.add(backward)) {
                    q.offer(backward);
                }
            }
            ++steps;
        }
        return -1;
    }
}