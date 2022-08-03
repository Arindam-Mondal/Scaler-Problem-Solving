package advance.arrays;


import java.util.ArrayList;

/**
 *
 * Maximum Absolute Difference
 *
 * Problem Description
 * You are given an array of N integers, A1, A2, .... AN.
 *
 * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum value of f(i, j).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 3, -1]
 * Input 2:
 *
 *
 * A = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 * 5
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 * Explanation 2:
 *
 * Only possibility is i = 1 and j = 1. That gives answer = 0.
 */
public class MaximumAbsoluteDifference {
    public int maxArr(ArrayList<Integer> A) {

        long maxSum1 = Integer.MIN_VALUE;
        long maxSum2 = Integer.MIN_VALUE;

        long maxI1 = Integer.MIN_VALUE;
        long minI1 = Integer.MAX_VALUE;

        long maxI2 = Integer.MIN_VALUE;
        long minI2 = Integer.MAX_VALUE;

        for(int i=0;i<A.size();i++){
            int val1 = A.get(i) + i;
            int val2 = A.get(i) - i;

            maxI1 = Math.max(maxI1,val1);
            minI1 = Math.min(minI1,val1);

            maxI2 = Math.max(maxI2,val2);
            minI2 = Math.min(minI2,val2);

            maxSum1 = Math.max(maxSum1, maxI1 - minI1);
            maxSum2 = Math.max(maxSum2, maxI2 - minI2);
        }

        return (int) Math.max(maxSum1,maxSum2);
    }
}
