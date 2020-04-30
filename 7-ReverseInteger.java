/**
 ** reverse an integer's bit including its sign.
 ** example: -321 ---> -123
 ** return 0 if there is an overflow. The two if statements are conditions for
 **   overflow if the integer is positive or negative.
*/
class Solution {
    public int reverse(int x) {
        int reverse = 0;

        while (x != 0) {
            int unit = x % 10;

            if ((reverse > Integer.MAX_VALUE / 10)
                || (reverse == (Integer.MAX_VALUE / 10) && unit > 7)) {
                return 0;
            }

            if ((reverse < Integer.MIN_VALUE / 10)
                || (reverse == (Integer.MIN_VALUE / 10) && unit < -8)) {
                return 0;
            }

            x /= 10;
            reverse = reverse * 10 + unit;
        }
        return reverse;
    }
}
