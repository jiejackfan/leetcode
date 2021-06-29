// 06/16/2021

class Solution {
    // simulation
    // traverse through the array just like the arrow, one element at a time
    // O(n * m)
    // O(n * m)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return ans;
        
        int up = 0, right = matrix[0].length - 1;
        int left = 0, down = matrix.length - 1;
        int m = matrix.length, n = matrix[0].length;
        
        while(ans.size() < m * n) {
            for (int i = left; i <= right && ans.size() < m*n; i++) {
                ans.add(matrix[up][i]);
            }
            for (int j = up + 1; j <= down - 1 && ans.size() < m*n; j++) {
                ans.add(matrix[j][right]);
            }
            for (int i = right; i >= left && ans.size() < m*n; i--) {
                ans.add(matrix[down][i]);
            }
            for (int j = down - 1; j>= up + 1 && ans.size() < m*n; j--) {
                ans.add(matrix[j][left]);
            }
            left++; right--; up++; down--;
        }
        return ans;
    }
}