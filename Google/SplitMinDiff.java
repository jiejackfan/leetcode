import java.lang.Integer;

public class SplitMinDiff {
    
    // O(n)
    // O(1)
    public static int splitMinDiff(int n) {
        int ans = Integer.MAX_VALUE;

        // convert int into ArrayList of digits
        String temp = Integer.toString(n);
        if (temp.length() <= 1) return Integer.parseInt(temp); 
        // // loop every interval and calculate the diff, update ans if nessesary
        for (int i = 1; i < temp.length(); i++) {
            String sub1 = temp.substring(0, i);
            String sub2 = temp.substring(i); 
            ans = Math.min(ans, Math.abs(Integer.parseInt(sub1) - Integer.parseInt(sub2)));
        }

        return ans;
    }
    public static void main(String[] args) {
        //int input = 12001;
        int input = 510;
        System.out.println(splitMinDiff(input));
    }   
}
