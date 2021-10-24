class Solution {
    // Approach 1: hashtable
    // Record # of appearances for each number into a hashtable
    // sort the given array with ascending order of # of appear
    // return 
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k == arr.length)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] nums = new Integer[arr.length];
        int index = 0;
        
        for (int n : arr) {
            // copy arr to nums
            nums[index++] = n;
            // map record how many appearances for each number
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // if not removing, return map size
        if (k == 0)
            return map.size();
        
        // sort based on ascending order of # of appearances
        Arrays.sort(nums, new Comparator<Integer>() {
           public int compare(Integer a, Integer b) {
               int n1 = map.get(a), n2 = map.get(b);
               return (n1 != n2) ? (n1 - n2) : (a - b);
           } 
        });
        
        // only add ones at the back (with more # of appearances)
        // add to hashset first to avoid duplicates
        Set<Integer> hs = new HashSet<>();
        for (int i = k; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        
        return hs.size();
        
    }
}