// April 16, 2021
// Not very confident on the last 2 solutions

class Solution {
    // brute force
    // O(n*k) O(1)
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        for (int i = 0; i < k; i++) {
            int prev = nums[nums.length-1];
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
            
        }
    }
    
    // Using extra array
    // O(n) O(n)
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
    
    // Cyclic replacement
    // O(n) O(1)
    // Don't really know whats going on in this solution.
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start ++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    
    // Reverse the array
    // O(n) O(1)
    // Reverse all numbers, reverse first k numbers, reverse last n-k elements
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    // 9/15 two pointer practice
        // Approach 1: Reverse
    // Reverse all numbers, reverse first k numbers, and reverse last n-k numbers to acheive the answer
    // O(n) O(1)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    // reverse the numbers within the given range, switch left and right while incrementing/decrementing
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}