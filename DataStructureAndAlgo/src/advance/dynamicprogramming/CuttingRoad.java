package advance.dynamicprogramming;

import java.util.ArrayList;

/**
 *  Cutting a Rod
 *
 *  Problem Description
 * Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
 *
 * Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * 0 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 4, 1, 6, 2]
 * Input 2:
 *
 *  A = [1, 5, 2, 5, 6]
 *
 *
 * Example Output
 * Output 1:
 *
 *  15
 * Output 2:
 *
 *  11
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
 * Explanation 2:
 *
 *  Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
 */
public class CuttingRoad {
    int[] dp;
    ArrayList<Integer> cost;
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        cost = new ArrayList<>();
        cost.add(0);
        for(int i=0;i<n;i++){
            cost.add(A.get(i));
        }
        return findMaxCost(n);

    }

    public int findMaxCost(int N){
        if(N == 0){
            return 0;
        }
        if(dp[N] != -1){
            return dp[N];
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            ans = Math.max(ans,cost.get(i) + findMaxCost(N-i));
        }
        dp[N] = ans;
        return ans;
    }
}
