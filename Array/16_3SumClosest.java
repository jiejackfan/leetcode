// 6/16/2021
class Solution {
    // Two Pointer approach similar to ThreeSum problem
    // O(n^2)
    // O(log n) quick sort
    // Sort the input array, for each element use 2 pointers to find sum of 3 numbers that gives the smallest diff
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        //for each element, search for three sum using the two pointer solution
        for (int i = 0; i < nums.length && diff != 0; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                // if we find a smaller diff, replace the old diff
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                
                // if sum is less than target, increase lo pointer
                if (sum < target) lo++;
                // else if sum is greater than target, decrease hi pointer
                else hi--;
            }
        }
        return target - diff;
    }
}