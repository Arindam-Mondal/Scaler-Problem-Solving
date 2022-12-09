package advance.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Coin Sum Infinite
 *
 * Problem Description
 * You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
 *
 * NOTE:
 *
 * Coins in set A will be unique. Expected space complexity of this problem is O(B).
 * The answer can overflow. So, return the answer % (106 + 7).
 *
 *
 * Problem Constraints
 * 1 <= A <= 500
 * 1 <= A[i] <= 1000
 * 1 <= B <= 50000
 *
 *
 *
 * Input Format
 * First argument is an integer array A representing the set.
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of ways.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 *  B = 4
 * Input 2:
 *
 *  A = [10]
 *  B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The 4 possible ways are:
 *  {1, 1, 1, 1}
 *  {1, 1, 2}
 *  {2, 2}
 *  {1, 3}
 * Explanation 2:
 *
 *  There is only 1 way to make sum 10.
 */
public class CoinSumInfinite2 {
    public int coinchange2(ArrayList<Integer> A, int B) {
        A.add(0,0);
        int[][] dp = new int[2][B+1];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        dp[0][0] = 1;
        dp[1][0] = 1;
        int mod = 1000007;

        for(int i=1;i<A.size();i++){
            for(int j=1;j<=B;j++){
                if(j>=A.get(i)){
                    dp[i%2][j] = (dp[(i-1)%2][j]%mod + dp[i%2][j-A.get(i)]%mod)%mod;
                }else{
                    dp[i%2][j] = dp[(i-1)%2][j]%mod;
                }
                // System.out.print(dp[i%2][j]);
            }
        }
        return dp[(A.size()-1)%2][B];
    }
}
