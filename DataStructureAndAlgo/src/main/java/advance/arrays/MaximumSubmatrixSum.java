package advance.arrays;

import java.util.ArrayList;

/**
 * Maximum Submatrix Sum (Row wise and Column wise sorted Matrix)
 *
 * Problem Description
 * Given a row-wise and column-wise sorted matrix A of size N * M.
 * Return the maximum non-empty submatrix sum of this matrix.
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -109 <= A[i][j] <= 109
 *
 *
 * Input Format
 * The first argument is a 2D integer array A.
 *
 *
 * Output Format
 * Return a single integer that is the maximum non-empty submatrix sum of this matrix.
 *
 *
 * Example Input
 * Input 1:-
 *     -5 -4 -3
 * A = -1  2  3
 *      2  2  4
 * Input 2:-
 *     1 2 3
 * A = 4 5 6
 *     7 8 9
 *
 *
 * Example Output
 * Output 1:-
 * 12
 * Output 2:-
 * 45
 *
 *
 * Example Explanation
 * Expanation 1:-
 * The submatrix with max sum is
 * -1 2 3
 *  2 2 4
 *  Sum is 12.
 * Explanation 2:-
 * The largest submatrix with max sum is
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * The sum is 45.
 */
public class MaximumSubmatrixSum {

    public Long solve(ArrayList<ArrayList<Integer>> A) {
        //Create prefixSum in reverse order

        int n = A.size();
        int m = A.get(0).size();
        long[][] prefixSum = new long[n][m];
        long maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            prefixSum[i][m-1] = A.get(i).get(m-1);
            maxSum = Math.max(maxSum,prefixSum[i][m-1]);
        }
        for(int i=0;i<n;i++){
            for(int j=m-2;j>=0;j--){
                prefixSum[i][j] = prefixSum[i][j+1] + A.get(i).get(j);
                maxSum = Math.max(maxSum,prefixSum[i][j]);
            }
        }
        for(int j=0;j<m;j++){
            for(int i=n-2; i>=0;i--){
                prefixSum[i][j] = prefixSum[i+1][j] + prefixSum[i][j];
                maxSum = Math.max(maxSum,prefixSum[i][j]);
            }
        }

        return maxSum;
    }
}