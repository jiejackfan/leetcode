
import java.lang.String;

public class RemoveB {

    public static int removeB(String s) {
        int ans = Integer.MAX_VALUE;
        // dp1 stores optimal result from left to right
        int[] dp1 = new int[s.length()];
        // dp2 stores optimal result from right to left
        int[] dp2 = new int[s.length()];

        dp1[0] = s.charAt(0) == 'b'? 1 : 0;
        dp2[s.length()-1] =  s.charAt(s.length() - 1) == 'b' ? 1 : 0;  
        // loop 1 to fill in dp1, the cost of removing from the left of each character
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == 'a')
                dp1[i] = dp1[i - 1];
            else {
                dp1[i] = Math.min(i + 1, dp1[i - 1] + 2);
            }
        }

        // loop 2 
        for (int i = s.length() - 2; i >= 0; i--) {
            if(s.charAt(i) == 'a')
                dp2[i] = dp2[i + 1];
            else {
                dp2[i] = Math.min(s.length() - i, dp2[i + 1] + 2);
            }
        }
        // loop 3 to calculate answer, find the minimum of dp1[i] + dp2[i]
        for (int i = 0; i < s.length(); i++) {
            ans = Math.min(ans, dp1[i] + dp2[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        // //String input = "aabaa";
        //  String input = "abbaaba";
        // String input = "bbb";
        // String input = "abbbaabaabba";
        
        String input = "bbbbabbabaaaabaabbaaaaaabbbbaaabababbabaabbbbbb";

        System.out.println(removeB(input));
    }   
}
