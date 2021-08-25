// 8/24/2021
class Solution {
    
    // Solution 1-4 needs to modify array, does not satisfy requirement
    // Solution 5-7 are correct
    
    // Solution 1: Sort
    // Sort the array, the duplicate number will be next to each other
    // public int findDuplicate(int[] nums) {
    //     Arrays.sort(nums);
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] == nums[i-1])
    //             return nums[i];
    //     }
    //     return -1;
    // }
    
    // Solution 5: Binary Search
    // For each number, count of numbers less or equal to this number should
    // would be greater than the number itself. I.e. 4 should have 4 numbers.
    // if the count exceeds the number itself, we know this is a duplicate.
    // Start from middle of array, do binary search of the above step
    // find the smallest number than cur > num
    public int findDuplicate(int[] nums) {
        // low and high includes range of numbers within num
        int low = 1, high = nums.length - 1;
        int duplicate = -1;
        
        // binary search exhaustive search range
        while (low <= high){
            int cur = (low + high) / 2;
            
            // count how many number in nums are less or equal to cur
            int count = 0;
            for (int num : nums) {
                if (num <= cur)
                    count++;
            }
            
            // if we know there is a duplicate before or at cur, we search in the left
            if (count > cur) {
                duplicate = cur;
                high = cur - 1;
            }
            // else we search in the right
            else {
                low = cur + 1;
            }
        }
        return duplicate;
    }
}