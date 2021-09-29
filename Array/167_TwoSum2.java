class Solution {
    // brute force
    // go through every paring and find if theres a pair of values that can add up to the target
    // O(n^2)
    // O(1)
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        return null;
    }
    
    // HashTable (Two sum solution)
    public int[] twoSum(int[] numbers, int target) {
        // first index = number, second index = 
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target-numbers[i]) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return null;
        
    }
    
    // Two pointer
    // Previous 2 methods are not using a given key information: sorted in on-decreasing order
    // Using a 2 point approach, pointer at each end, move the left pointer if the current sum is less than target, vice versa
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            else if (numbers[left] + numbers[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        
        return null;
    }
}