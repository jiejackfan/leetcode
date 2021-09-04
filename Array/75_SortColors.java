//9/3/2021
class Solution {
    // Dutch flag problem
    
    // Approach 1: One Pass
    // Keep 3 pointers. p0, p2 and current pointer.
    // Go one element at a time, if curr is 0, we swap with p0 pointer. if curr is 2, we swap with p2 pointer
    // O(n) O(1)
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length-1;
        int curr = 0;
        
        // while curr is less than or equal to p2
        while (curr <= p2) {
            // three different actions for 3 diff numbers
            // if 0, swap and increase curr and p0
            if (nums[curr] == 0) {
                int tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            // if 2, swap curr and p2, decrease p2.
            // we don't touch curr pointer here because we need to consider the newly swaped curr element.
            else if (nums[curr] == 2) {
                int tmp = nums[p2];
                nums[p2--] = nums[curr];
                nums[curr] = tmp;
            }
            else {
                curr++;
            }
        }
    }
}