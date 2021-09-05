// 9/4/2021
class Solution {
    
    // Approach 1: HashMap Brute Force
    // O(n^2) O(n^2)
    // We will use hashmap to store the sum and count of the first 2 arrays. Then we loop through different sums of the last 2
    // arrays to find out total combination count. 
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // Build hashmap of first 2 arrays
        // key=possible sum combinations value=count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1: nums1) {
            for (int num2: nums2) {
                map.put(num1+num2, map.getOrDefault(num1+num2, 0) + 1);
            }
        }
        
        // loop through sum combinations of last 2 arrays
        // if matches to hashmap then add to answer
        // a + b = - (c + d)
        int ans = 0;
        for (int num3: nums3) {
            for (int num4: nums4) {
                ans += map.getOrDefault(-(num3 + num4), 0);
            }
        }
        
        return ans;
    }
    
    // Approach 2: kSum II Generalized Solution
    // O(n ^ (k/2)) 
    // O(n ^ (k/2)) 
    // Similar approach, create hashtable for first k/2 arrays and count the next k/2 arrays
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        return kSumCount(new int[][]{nums1, nums2, nums3, nums4});
    }
    
    public int kSumCount(int[][] lists) {
        Map<Integer, Integer> map = new HashMap<>();
        
        addToHash(lists, map, 0, 0);
        
        return countComplements(lists, map, lists.length / 2, 0);
    }
    
    // recursive function to add all combination of sums of the first k/2 arrays into a hashtable
    public void addToHash(int[][] lists, Map<Integer, Integer> map, int i, int sum) {
        // base case
        if (i == lists.length / 2) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        // if we need to add more lists to our current sum
        // we do more recursion
        else {
            for (int a : lists[i])
                addToHash(lists, map, i+1, sum + a);
        }
    }
    
    // recursive function to see wether sum combination of the last k/2 arrays matches the complement of 
    // what is stored in hashtable
    public int countComplements(int[][] lists, Map<Integer, Integer> map, int i, int complement) {
        // base case
        if (i == lists.length)
            return map.getOrDefault(complement, 0);
        
        // else we recur to add more lists to our sum. keep track of count
        int ans = 0;
        for (int a : lists[i])
            ans += countComplements(lists, map, i+1, complement - a);
        return ans;
    }
    
}