import java.util.HashMap;
import java.lang.Math;
public class MaxK {

    public static int maxK(int[] A) {
        int ans = 0;
        // map 1 stores Ai - i
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        // map 2 stores Ai + i
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

        // loop for map1
        for (int i = 0; i < A.length; i++) {
            // if never seen this Ai-i combination before
            if(!map1.containsKey(A[i] - i)) {
                map1.put(A[i] - i, i);
            }
            // update max answer
            ans = Math.max(ans, i - map1.get(A[i] - i));
        }
        // loop for map2
        for (int i = 0; i < A.length; i++) {
            // if never seen this Ai+i combination before
            if(!map2.containsKey(A[i] + i)) {
                map2.put(A[i] + i, i);
            }
            // update max answer
            ans = Math.max(ans, i - map2.get(A[i] + i));
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] input = new int[]{2, 2, 2, 1};
        //int[] input = new int[]{2, 4, 6, 7, 4, 7, 2};
        //int[] input = new int[]{100,100,100};
        
        System.out.println(maxK(input));
    }   
}

