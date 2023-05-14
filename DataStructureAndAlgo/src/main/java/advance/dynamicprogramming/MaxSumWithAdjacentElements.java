package advance.dynamicprogramming;

import java.util.ArrayList;

/**
 * Max Sum Without Adjacent Elements
 *
 * Problem Description
 *
 * Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
 *
 * Note: You can choose more than 2 numbers.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 20000
 * 1 <= A[i] <= 2000
 *
 *
 *
 * Input Format
 *
 * The first and the only argument of input contains a 2d matrix, A.
 *
 *
 *
 * Output Format
 *
 * Return an integer, representing the maximum possible sum.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [
 *         [1]
 *         [2]
 *      ]
 * Input 2:
 *
 *  A = [
 *         [1, 2, 3, 4]
 *         [2, 3, 4, 5]
 *      ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  8
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  We will choose 2.
 * Explanation 2:
 *
 *  We will choose 3 and 5.
 */
public class MaxSumWithAdjacentElements {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> maxElements = new ArrayList<>();
        //to convert it to 1 based indexing - will be easy for calculating the max elements
        maxElements.add(0);
        //Finding the maximum for a given column between the two rows.
        ArrayList<Integer> row1 = A.get(0);
        ArrayList<Integer> row2 = A.get(1);
        int n = row1.size();

        for(int i=0;i<n;i++){
            maxElements.add(Math.max(row1.get(i),row2.get(i)));
        }
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = maxElements.get(1);

        for(int i=2;i<result.length;i++){
            result[i] = Math.max(maxElements.get(i)+result[i-2],result[i-1]);
        }

        return result[n];
    }
}
