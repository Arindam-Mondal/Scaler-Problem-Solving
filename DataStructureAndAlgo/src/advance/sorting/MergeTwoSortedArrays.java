package advance.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge Two Sorted Arrays
 *
 * Problem Description
 * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
 *
 *
 *
 * Problem Constraints
 * -1010 <= A[i], B[i] <= 1010
 *
 *
 *
 * Input Format
 * First Argument is a 1-D array representing A.
 *
 * Second Argument is also a 1-D array representing B.
 *
 *
 *
 * Output Format
 * Return a 1-D vector which you got after merging A and B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [4, 7, 9 ]
 * B = [2, 11, 19 ]
 * Input 2:
 *
 * A = [1]
 * B = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 4, 7, 9, 11, 19]
 * Output 2:
 *
 * [1, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Merging A and B produces the output as described above.
 * Explanation 2:
 *
 *  Merging A and B produces the output as described above.
 */
public class MergeTwoSortedArrays {

    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> sortedList = new ArrayList<>();

        while(i<A.size() && j<B.size()){
            if(A.get(i)<B.get(j)){
                sortedList.add(A.get(i));
                i++;
            }else{
                sortedList.add(B.get(j));
                j++;
            }
        }

        while(i<A.size()){
            sortedList.add(A.get(i));
            i++;
        }

        while(j<B.size()){
            sortedList.add(B.get(j));
            j++;
        }

        return sortedList;
    }
}
