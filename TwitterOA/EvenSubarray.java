import java.util.*;

class EvenSubarray {
    // Brute force solution, try to find all possible subarrays that satisfy m odd numbers contraint
    public static int countSubarrays(int a[], int n, int m) {
        
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int odd = 0;
            for (int j = i; j < n; j++) {
                if (a[j] % 2 != 0)
                    odd++;
                
                // iff odd == m
                if (odd == m) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // Driver code
    public static void main(String[] args)
    {
        int a[] = { 2, 2, 5, 6, 9, 2, 11 };
        int n = a.length;
        int m = 2;
    
        System.out.println(countSubarrays(a, n, m));
    }
}