// 9/2/2021

class Solution {
    
    // recursion -> backtracking -> lexicographic generation
    
    // Approach 1: cascading 
    // For every number, build a subset of previous sets + this num. Then add the subset into output for next num
    // O(n * 2^n)
    // O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        // add the empty subset
        output.add(new ArrayList<Integer>());
    
        // for every element, we add to our list
        for (int num : nums) {
            // create storage for new subsets
            List<List<Integer>> newSubsets = new ArrayList();
            
            // add curr number to all previous subsets, we create new subsets
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){
                    {
                        add(num);
                    }
                });
            }
            
            // add new subsets into the output
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        
        return output;
    }
    
    // Approach 2: Backtracking
    // O(n * 2^n)
    // O(n)
    // For each possible length of combination, use backtrack recursion to find all of its elements
//     List<List<Integer>> output = new ArrayList();
//     int n, k;
    
    public void backtrack (int first, ArrayList<Integer> curr, int[] nums) {
        // if current combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        
        // else we try adding different letters
        for (int i = first; i < n; i++) {
            // add i to combination, recur and remove i
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) { 
        n = nums.length;
        for (k = 0; k <= n; k++) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        
        return output;
    }
    
    
    // Approach 3: Lexicographic Subset
    // O(n* 2^n)
    // O(n* 2^n)
    // View numbers as bitmasks, where 1 on ith position emans nums[i] is in the subset
    // Generate bit masks from all 000 to all 111.
    public List<List<Integer>> subsets(int[] nums) { 
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n+1); i++) {
            // generate bit masks
            String bitmask = Integer.toBinaryString(i).substring(1);
            
            // append subset corresponding to bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; j++) {
                if (bitmask.charAt(j) == '1')
                    curr.add(nums[j]);
            }
            output.add(curr);
        }
        
        return output;
    }
}