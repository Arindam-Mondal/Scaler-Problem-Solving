package advance.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * N digit numbers
 *
 * Problem Description
 * Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
 *
 * Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
 *
 * Since the answer can be large, output answer modulo 1000000007
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1000
 *
 * 1 <= B <= 10000
 *
 *
 *
 * Input Format
 * First argument is the integer A
 *
 * Second argument is the integer B
 *
 *
 *
 * Output Format
 * Return a single integer, the answer to the problem
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 *  B = 4
 * Input 2:
 *
 *  A = 1
 *  B = 3
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
 *  Valid numbers are {22, 31, 13, 40}
 *  Hence output 4.
 * Explanation 2:
 *
 *  Only valid number is 3
 *
 */
public class NDigitsNumber {
    int[][] dp;
    public int solve(int A, int B) {
        dp = new int[A+1][B+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return findDigits(A,B,1);
    }

    public int findDigits(int A, int B, int start){
        if(A == 1){
            if(B>9) return 0;
            return 1;
        }


        if(dp[A][B] != -1){
            return dp[A][B];
        }

        int sum = 0;
        int mod = 1000000007;

        for(int i=start;i<=9 && i<=B;i++){
            sum = (sum%mod + findDigits(A-1,B-i,0)%mod)%mod;
        }
        dp[A][B] = sum;
        return dp[A][B];
    }
}
