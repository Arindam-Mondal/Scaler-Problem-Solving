package ArrayProblems;

import java.util.ArrayList;

/**
 * Problem Description
 * A wire connects N light bulbs.
 *
 * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
 *
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 *
 * You can press the same switch multiple times.
 *
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 5×105
 * 0 <= A[i] <= 1
 *
 *
 *
 * Input Format
 * The first and the only argument contains an integer array A, of size N.
 *
 *
 *
 * Output Format
 * Return an integer representing the minimum number of switches required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [0, 1, 0, 1]
 * Input 2:
 *
 *  A = [1, 1, 1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  press switch 0 : [1 0 1 0]
 *  press switch 1 : [1 1 0 1]
 *  press switch 2 : [1 1 1 0]
 *  press switch 3 : [1 1 1 1]
 * Explanation 2:
 *
 *  There is no need to turn any switches as all the bulbs are already on.
 */
public class BulbsMain {
    public static void main(String[] args) {
        ArrayList<Integer> bulbsArray = new ArrayList<>();
        bulbsArray.add(0);
        bulbsArray.add(1);
        bulbsArray.add(1);
        bulbsArray.add(0);
        bulbsArray.add(1);
        System.out.println(new Bulbs().bulbs(bulbsArray));
    }
}

class Bulbs {
    public int bulbs(ArrayList<Integer> A) {
        int S = 0;
        int C = 0;
        for(int i=0;i<A.size();i++){
            if(A.get(i) == S) {
                C++;
                S = S == 0 ? 1 : 0;
            }
        }
        return C;
    }
}
