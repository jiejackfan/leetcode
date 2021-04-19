// April 18, 2021

class Solution {
    
    // HashMap
    // O(n + m), O(min(n, m))
    // copy one array into a hashmap
    // compare second array elements to those in hashmap
    // add intersection back to the first array
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        
        HashMap<Integer, Integer> record = new HashMap<>();
        
        for (int i: nums1) {
            record.put(i, record.getOrDefault(i, 0) + 1);
        }
        
        int curr = 0;
        for (int i : nums2) {
            int count = record.getOrDefault(i, 0);
            if (count > 0) {
                nums1[curr++] = i;
                record.put(i, record.get(i) - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, curr);
    }
    
    // Sort and two pointer
    // O(nlogn + mlogm + max(m, n))  sorting algorithm + one pass
    // O(m+n)  from sorting algorithm
    // Sort the two arrays, and one pass using two pointers
    // Move the intersecting numbers into nums1 and return that section of nums1
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
            else if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] < nums2[j]) i++;

        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    
    // What if the given array is already sorted? How would you optimize your algorithm?
    // If array is sorted, using the two pointer method. Only requires one pass.
    
    // What if nums1's size is small compared to nums2's size? Which algorithm is better?
    // Hashmap method is better because our hashmap will take less memory.
    
    // What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at     // once?
    // 1. If nums1 can fit in memory, put nums1 in hashmap and sequentially load and process nums2.
    // 2. If neither fit in memory. 
        // Split numeric range into subranges that fits into the memory. Build hashtable for each subrange.
        // OR
        // Use external sort for both array. Load arrays sequentially to compare.
    
}