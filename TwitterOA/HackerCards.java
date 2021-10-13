import java.util.*;
public class HackerCards {
    public static int[] hackerCards(int[] cards, int len, int d) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int s , e;
        for (int i = 0; i <= len; i++) {
            
            if (i == 0) {
                s = 1;
            } else {
                s = cards[i-1] + 1;
            }

            if (i != len) {
                e = cards[i];
            } else {
                e = Integer.MAX_VALUE;
            }

            if (d < s) break;

            for (int k = s; k < e; k++) {
                if (k <= d) {
                    result.add(k);
                    d -= k;
                } else {
                    break;
                }
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args)
    {
        int a[] = new int[]{ 2, 4, 5 };
        int n = a.length;
        int m = 7;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(hackerCards(a, n, m)));
    }
}
