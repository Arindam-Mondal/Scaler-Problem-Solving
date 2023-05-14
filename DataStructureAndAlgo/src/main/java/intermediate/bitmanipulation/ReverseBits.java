package intermediate.bitmanipulation;

import java.util.ArrayList;

/**
 * Problem Description
 * Reverse the bits of an 32 bit unsigned integer A.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 232
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer A.
 *
 *
 *
 * Output Format
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  0
 * Input 2:
 *
 *  3
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  3221225472
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *         00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 * Explanation 2:
 *
 *         00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 */
public class ReverseBits {
    public long reverse(long a) {
        ArrayList<Long> bits = new ArrayList<>();
        int i=32;
        while(i>0){
            bits.add((long)a%2);
            a=a/2;
            i--;
        }
        // System.out.println(bits);
        long result = 0;
        for(int j=0;j<bits.size();j++){
            result = result + (bits.get(j) * (long)Math.pow(2,(31-j)));
        }
        return result;
    }
}
