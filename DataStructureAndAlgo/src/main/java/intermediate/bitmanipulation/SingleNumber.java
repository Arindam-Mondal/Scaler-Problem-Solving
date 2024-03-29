package intermediate.bitmanipulation;

import java.util.List;

/**
 * Problem Description
 * Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
 *
 * NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 *
 *
 * Problem Constraints
 * 2 <= |A| <= 2000000
 *
 * 0 <= A[i] <= INTMAX
 *
 *
 *
 * Input Format
 * The first and only argument of input contains an integer array A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the single element.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 2, 3, 1]
 * Input 2:
 *
 *  A = [1, 2, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 3 occurs once.
 * Explanation 2:
 *
 * 1 occurs once.
 */
public class SingleNumber {

    public int singleNumber(final List<Integer> A) {
        // Map<Integer,Integer> R = new HashMap<>();
        // for(int i=0;i<A.size();i++){
        //     if(R.get(A.get(i)) == null){
        //         R.put(A.get(i),1);
        //     }else {
        //         R.put(A.get(i),R.get(A.get(i)) + 1);
        //     }
        // }
        // int result = 0;

        // for (Integer key: R.keySet()) {
        //     if(R.get(key) == 1) result = key;
        // }

        // return result;

        // Another Solution
        int result = 0;
        for(int i =0;i<A.size();i++){
            result = result ^ A.get(i);
        }
        return result;
    }
}
