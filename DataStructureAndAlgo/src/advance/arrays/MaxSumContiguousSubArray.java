package advance.arrays;

import java.util.List;

/**
 * Problem Description
 * Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 * The first and the only argument contains an integer array, A.
 *
 *
 *
 * Output Format
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, -10]
 * Input 2:
 *
 *  A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * Explanation 2:
 *
 *  The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaxSumContiguousSubArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        //Using kadanes algorithm

        int contribution = 0;
        int sum = Integer.MIN_VALUE;

        //if contribution becomes less than 0 start from the begining.
        for(int i=0;i<A.size();i++){
            contribution = contribution + A.get(i);
            sum = Math.max(sum,contribution);
            if(contribution<0){
                contribution = 0;
            }
        }
        return sum;
    }
}
