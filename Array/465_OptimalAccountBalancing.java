class Solution {
    // Approach 1: 
    // O(n!)
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        
        // build a list of each person's debt, positive debt needs to be paid, vice versa
        for (int[] t : transactions) {
            // 
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
        }
        
        return settle(0, new ArrayList<>(m.values()));
    }
    
    int settle (int start, List<Integer> debt) {
        // find the first person with +/- debt
        // if a person has debt keep processing until 0
        while (start < debt.size() && debt.get(start) == 0) 
            start++;
        
        // if we exceeded the amount of ppl, exit
        // base case
        if (start == debt.size())
            return 0;
        
        int r = Integer.MAX_VALUE;
        
        // try to see if debt[start] can match each debt after start
        // do dfs
        for (int i = start + 1; i < debt.size(); i++) {
            if (debt.get(start) * debt.get(i) < 0) {
                debt.set(i, debt.get(i) + debt.get(start));
                r = Math.min(r, 1 + settle(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        }
        return r;
    }
}