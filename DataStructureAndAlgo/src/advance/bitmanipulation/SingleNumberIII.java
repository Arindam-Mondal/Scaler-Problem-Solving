package advance.bitmanipulation;

import java.util.ArrayList;

/**
 *
 * Single Number III
 *
 * Problem Description
 * Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
 * Find the two integers that appear only once.
 *
 * Note: Return the two numbers in ascending order.
 *
 *
 * Problem Constraints
 * 2 <= |A| <= 100000
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument is an array of integers of size N.
 *
 *
 *
 * Output Format
 * Return an array of two integers that appear only once.
 *
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 1, 2, 4]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 * [3, 4]
 * Output 2:
 *
 * [1, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 * 3 and 4 appear only once.
 * Explanation 2:
 *
 * 1 and 2 appear only once.
 */
public class SingleNumberIII {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int allXor = 0;
        int pos = 0;
        ArrayList<Integer> result = new ArrayList();

        for(int i=0;i<A.size();i++){
            allXor = allXor ^ A.get(i);
        }

        for(int i=0;i<32;i++){
            if((allXor>> i) % 2 == 1){
                pos = i;
                break;
            }
        }

        int set = 0;
        int unset = 0;

        for(int i=0;i<A.size();i++){
            if((A.get(i)>>pos) % 2 == 1){
                set = set ^ A.get(i);
            }else {
                unset = unset ^ A.get(i);
            }
        }

        result.add(unset);
        result.add(set);
        result.sort((a,b)-> a.compareTo(b));
        return result;
    }
}
