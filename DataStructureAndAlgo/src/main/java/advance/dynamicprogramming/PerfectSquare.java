package main.java.advance.dynamicprogramming;

/**
 *Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 *
 * explanation : https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
 */
public class PerfectSquare {
    public int numSquares(int n) {
        //using dp
        if(n<=3){
            return n;
        }
        int[] dp = new int[n+1];
        for(int i=0;i<=3;i++){
            dp[i] = i;
        }

        for(int i=4;i<=n;i++){
            dp[i] = i;
            for(int k=1;k*k<=i;k++){
                int temp = k*k;
                if(temp>i){
                    break;
                }else{
                    dp[i] = Math.min(dp[i],1+dp[i-temp]);
                }
            }
        }
        return dp[n];

    }
}
