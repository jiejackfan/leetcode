// 6/14/2021
// Only 2 pointer solution, 2 more solution not implemented

class Solution {
    // Sort and Two Pointer
    // O(n^2) n iterations of twosum2
    // O(log n) quicksort for java
    // Sort the array first, start iterating from the first number
    // Set up pointer at each end for each iteration. Find if the sum of three pointers match the target.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        //sort the array first
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 3 && nums[i] <= 0; i++) {
            // if the value is the same as the one before, skip it
            // an example is [0, 0, 0, 0], the solution should be [0,0,0] 
            if (i==0 || nums[i-1] != nums[i]) {
                TwoSum2(nums, i, ans);
            }       

        }
        return ans;
    }
    
    // O(n)
    private void TwoSum2(int[] nums, int i, List<List<Integer>> ans) {
        int left = i + 1;
        int right = nums.length - 1;

        int remain = 0 - nums[i];

        while (left < right) {
            if (nums[left] + nums[right] > remain) {
                right--;
            }
            else if (nums[left] + nums[right] < remain) {
                left++;
            } 
            else {
                ans.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left - 1]) left++;
            }
        }
    }
}