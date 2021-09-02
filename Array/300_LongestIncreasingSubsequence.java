// 9/1/2021
class Solution {
    // Approach 1: DP
    // O(n^2)
    // O(n )
    // This problem is DP because 1.it asks for max 2. its answer depend on prev decisions
    public int lengthOfLIS(int[] nums) {
        // init dp array with all 1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        // for each member in dp table, we will loop to find the longest increasing subarray up till that element
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // if there is a chance of being an increasing subarray
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // now answer is one of dp table element
        // pick out the max and return it
        int longest = 0;
        for (int c : dp) {
            longest = Math.max(longest, c);
        }
        return longest;
    }
    
    // Approach 2 : Intelligently Build Subsequence
    // O(n * logn)
    // O(n)
    // Build array of subsequence, if number is greater than largest element in current array then we add this number
    // if number is smaller, perform scan of array and replace the first element greater or equal to current number
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            }
            else {
                // find first element in sub that is greater or equal to num
                
                // linear scan
                // int j = 0;
                // while (num > sub.get(j)) {
                //     j+=1;
                // }
                
                // binary search
                int j = binarySearch(sub, num);
                
                sub.set(j, num);
            }
        }
        return sub.size();
    }
    
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = left + (right - left)/2;
        
        while (left < right) {
            mid = left + (right - left)/2;
            if (sub.get(mid) == num)
                return mid;
            if (sub.get(mid) < num) 
                left = mid + 1;
            else if (sub.get(mid) > num)
                right = mid;
        }
        return left;
    }
}