//brute force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] tmp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    tmp[0] = i;
                    tmp[1] = j;
                    return tmp;
                }
            }
        }
        throw new IllegalArgumentException("no two sum solution.");
    }
}

// two pass
public int[] twoSum(int[] nums, int target) {
  HashMap<Integer, Integer> tmp = new HashMap<>();
  //put values into the hashmap
  for (int i = 0; i < nums.length; i++) {
    tmp.put(nums[i], i);
  }

  for (int i = 0; i < nums.length; i++) {
      int remaining = target - nums[i];
      if (tmp.containsKey(remaining) && tmp.get(remaining) != i) {
          return new int[] {i, tmp.get(remaining)};
      }
  }

  throw new IllegalArgumentException("no two sum solution.");
}

// one pass
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        //put values into the hashmap
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (tmp.containsKey(remaining)) {
                return new int[] {tmp.get(remaining), i};
            }
            tmp.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution.");
    }
}
