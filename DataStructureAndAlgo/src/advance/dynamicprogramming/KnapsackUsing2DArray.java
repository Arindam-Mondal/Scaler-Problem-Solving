package advance.dynamicprogramming;

import java.util.ArrayList;

/**
 * 0-1 Knapsack
 *
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 *
 * Also given an integer C which represents knapsack capacity.
 *
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 * NOTE:
 *
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 *
 * Problem Constraints
 * 1 <= N <= 103
 *
 * 1 <= C <= 103
 *
 * 1 <= A[i], B[i] <= 103
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N denoting the values on N items.
 *
 * Second argument is an integer array B of size N denoting the weights on N items.
 *
 * Third argument is an integer C denoting the knapsack capacity.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [60, 100, 120]
 *  B = [10, 20, 30]
 *  C = 50
 * Input 2:
 *
 *  A = [10, 20, 30, 40]
 *  B = [12, 13, 15, 19]
 *  C = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  220
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
 * Explanation 2:
 *
 *  Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 *
 */
public class KnapsackUsing2DArray {
    ArrayList<Integer> value;
    ArrayList<Integer> weight;
    int[][] dp;

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        A.add(0,0);
        B.add(0,0);

        dp = new int[A.size()][C+1];

        value = A;
        weight = B;

        return findMaxValue(A.size()-1,C);
    }

    public int findMaxValue(int i, int j){
        if(i<=0 || j<=0){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int ans = 0;

        if(j>=weight.get(i)){
            ans = Math.max(findMaxValue(i-1,j),value.get(i) + findMaxValue(i-1,j-weight.get(i)));
        }else{
            ans = findMaxValue(i-1,j);
        }

        dp[i][j] = ans;
        return ans;
    }
}
