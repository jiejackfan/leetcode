import java.util.*;

public class StringReduction {


    public static int minChanges(String str) {
        int distinct = 0;
        int count[] = new int[26];

        // initialize count
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }

        // go through each char, if encounter a distinct one we record
        // else just add to the count of this char
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - 'a'] == 0) {
                distinct++;
            }
            count[str.charAt(i) - 'a'] ++;
        }

        return str.length() - distinct;
    }

    public static void main (String[] args) {
         
        String str = "ababab";
         
        System.out.println(minChanges(str));
    }
}
