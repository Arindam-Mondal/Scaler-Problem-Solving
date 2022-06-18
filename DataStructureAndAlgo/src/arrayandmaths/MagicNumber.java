package arrayandmaths;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an integer A, find and return the Ath magic number.
 *
 * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
 *
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 5000
 *
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return the Ath magic number.
 *
 *
 *
 * Example Input
 * Example Input 1:
 *
 *  A = 3
 * Example Input 2:
 *
 *  A = 10
 *
 *
 * Example Output
 * Example Output 1:
 *
 *  30
 * Example Output 2:
 *
 *  650
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
 *  3rd element in this is 30
 * Explanation 2:
 *
 *  In the sequence shown in explanation 1, 10th element will be 650.
 *
 *  Observation(Arindam)
 *  n->sequence
 *  -->---------
 *  1-> 5^1
 *  2-> 5^1 + 5^2
 *  3-> 5^3
 *  4-> 5^1 + 5^3
 *
 *  From the above observation powers are nothing but the binary of the number(n) in the leftside
 */
public class MagicNumber {
    public int solve(int A) {
        ArrayList<Integer> binary = new ArrayList<>();
        while(A>0){
            binary.add(A % 2);
            A=A/2;
        }

        int r = 0;
        for(int i=binary.size()-1;i>=0;i--){
            if(binary.get(i) == 1){
                r = r + (int)Math.pow(5,i+1);
            }
        }
        return r;

    }
}
