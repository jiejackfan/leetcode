import java.lang.Math;
import java.util.ArrayList;

public class SecretArray {

    public static int countAnalogousArrays(ArrayList<Integer> consecutiveDifference, int lowerBound, int upperBound) {
        int highestSum =0, lowestSum = 0, sum = 0;
        for (Integer val : consecutiveDifference) {
            sum += val;
            highestSum = Math.max(sum, highestSum);
            lowestSum = Math.min(sum, lowestSum);
        }

        int res = (upperBound - lowerBound + (lowestSum - highestSum + 1));
        if (res < 0) {
            return 0;
        }
        else {
            return res;
        }

    }


    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(-2);input.add(-1);input.add(-2);input.add(5);
        int lower = 3, upper = 10;
        
        System.out.println(countAnalogousArrays(input, lower, upper));
    }   
}

