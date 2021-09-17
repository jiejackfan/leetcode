// April 19 2021

class Solution {
    // Two pointers
    // O(n) O(1)
    // i is slow pointer pointing at 0. j is fast pointer finding the next non-zero number
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}