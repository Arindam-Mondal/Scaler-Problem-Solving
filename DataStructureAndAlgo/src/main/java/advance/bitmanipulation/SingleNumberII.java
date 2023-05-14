package advance.bitmanipulation;

import java.util.List;

/**
 * Single Number II
 *
 * Problem Description
 * Given an array of integers, every element appears thrice except for one, which occurs once.
 *
 * Find that element that does not appear thrice.
 *
 * NOTE: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 *
 *
 *
 * Problem Constraints
 * 2 <= A <= 5*106
 *
 * 0 <= A <= INTMAX
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer array A.
 *
 *
 *
 * Output Format
 * Return a single integer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 * Input 2:
 *
 *  A = [0, 0, 0, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  4 occurs exactly once in Input 1.
 *  1 occurs exactly once in Input 2.
 */
public class SingleNumberII {
    public int singleNumber(final List<Integer> A) {
        int ans = 0;
        for(int i=0;i<32;i++){
            int noOfSetBit = 0;
            for(int j=0;j<A.size();j++){
                if((A.get(j) & (1<<i)) > 0){
                    noOfSetBit++;
                }
            }
            //get the mod 3 of the noOfSetBits , so to eliminate all the triplets.
            noOfSetBit = noOfSetBit % 3;
            ans = ans + noOfSetBit * (1<<i);
        }
        return ans;
    }
}
