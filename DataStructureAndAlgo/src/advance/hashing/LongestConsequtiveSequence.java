package advance.hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 *
 * Problem Description
 * Given an unsorted integer array A of size N.
 *
 * Find the length of the longest set of consecutive elements from array A.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 * -106 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 *
 * A = [2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 *
 *  The set of consecutive elements will be [1, 2].
 */
public class LongestConsequtiveSequence {

    public int longestConsecutive(final List<Integer> A) {
        int length = -1;
        int n = A.size();
        //Store the integers in a HashMap
        Set<Integer> frequencySet = new HashSet<>();
        for(int i=0;i<n;i++){
            frequencySet.add(A.get(i));
        }
        for(int i=0;i<n;i++){
            int num = A.get(i);
            if(!frequencySet.contains(num-1)){
                int count = 0;
                while(frequencySet.contains(num)){
                    count++;
                    num = num + 1;
                }
                length = Math.max(count,length);
            }
        }
        return length;
    }
}
