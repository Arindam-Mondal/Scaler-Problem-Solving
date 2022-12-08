package advance.dynamicprogramming;

import java.util.Arrays;

/**
 * Problem Description
 *
 * You are trying to send signals to aliens using a linear array of A laser lights. You don't know much about how the aliens are going to percieve the signals, but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.
 *
 * Find and return the total number of ways in which you can send a signal without compromising the safty of the earth. Return the ans % 109 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 *
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 *
 * Return the ans%(109+7).
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  OFF OFF
 *  OFF ON
 *  ON OFF
 * All lights off is also a valid signal which probably means 'bye'
 *
 * Explanation 2:
 *
 *  OFF OFF OFF
 *  OFF OFF ON
 *  OFF ON OFF
 *  ON OFF OFF
 *  ON OFF ON
 */
public class Signal {

    int dp[][];
    int mod = 1000000007;
    public int solve(int A) {
        dp = new int[A+1][2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 1;
        dp[1][1] = 1;

        return (findSignals(A,0)%mod + findSignals(A,1)%mod)%mod;
    }

    public int findSignals(int A,int state){
        if(A == 0){
            return 0;
        }

        int mod = 1000000007;

        if(dp[A][state] != -1){
            return dp[A][state]%mod;
        }

        if(state == 0){
            dp[A][state] = (findSignals(A-1,0) % mod + findSignals(A-1,1) % mod)%mod;
        }else{
            dp[A][state] = findSignals(A-1,0) % mod;
        }

        return dp[A][state] % mod;

    }
}
