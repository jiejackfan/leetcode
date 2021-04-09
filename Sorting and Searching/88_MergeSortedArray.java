// April 9, 2021

class Solution {
    // Naive approach
    // O(n+m) sorting algorithm,  O(n+m) storing var during sorting
    // Move elements from array 2 into array 1 and sort array 1 in place using builtin function
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     for (int i = 0; i < n; i++) {
    //         nums1[m+i] = nums2[i];
    //     }
    //     Arrays.sort(nums1);
    // }
    
    
    // Three pointers, starting from front
    // O(m+n) O(m)
    // Create a third array called nums1Copy to store current nums1 element.
    // Use nums1 as a new array and put numbers in to nums1 one by one.
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] nums1Copy = new int[m];
//         for (int i = 0; i < m; i++) {
//             nums1Copy[i] = nums1[i];
//         }
        
//         int ptr1 = 0;
//         int ptr2 = 0;
//         for (int i = 0; i < m+n; i++) {
//             if (nums1Copy[ptr1] < nums2[ptr2]) {
//                 nums1[i] = nums1Copy[ptr1];
//             } else {
//                 nums1[i] = nums2[ptr2];
//             }
//         } 
//     }
    
    // Three pointers, starting from end.
    // This is a medium solution.
    // Start from back of nums1 array and put in the bigger element in first.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = m+n-1; i >=0; i--) {
            if (p2 < 0) break;
            
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            }
            else {
                nums1[i] = nums2[p2];
                p2--;
                    
            }
        }
    }
    
}