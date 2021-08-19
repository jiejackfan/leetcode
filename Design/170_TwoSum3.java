// 8/18/2021

import java.util.Collections;

class TwoSum {
    private ArrayList<Integer> nums;
    private boolean is_sorted;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        this.nums = new ArrayList<Integer>();
        this.is_sorted = false;
    }
    
    /** Add the number to an internal data structure.. */
    // We use add more than find, so don't sort in add
    // O(1)
    // O(1)
    public void add(int number) {
        this.nums.add(number);
        this.is_sorted = false;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    // Sort the array first so we can use two pointer method finding two sum
    // O(nlogn)
    // O(1)
    public boolean find(int value) {
        if (!this.is_sorted) {
            Collections.sort(nums);
            this.is_sorted = true;
        }
        
        // use two pointer approach to find answer. Since the list of number is sorted, we can use this method
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int twoSum = this.nums.get(left) + this.nums.get(right);
            if (twoSum < value) {
                left++;
            }
            else if (twoSum > value) {
                right--;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */