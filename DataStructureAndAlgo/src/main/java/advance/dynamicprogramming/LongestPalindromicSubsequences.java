package advance.dynamicprogramming;

/**
 * Problem Description
 * Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
 *
 * You need to return the length of longest palindromic subsequence.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of(A) <= 103
 *
 *
 *
 * Input Format
 * First and only integer is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of longest palindromic subsequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "bebeeed"
 * Input 2:
 *
 *  A = "aedsead"
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The longest palindromic subsequence is "eeee", which has a length of 4.
 * Explanation 2:
 *
 *  The longest palindromic subsequence is "aedea", which has a length of 5.
 */
public class LongestPalindromicSubsequences {

    public int solve(String A) {
        //Solved using dynamic programming
        int[][] dp = new int[A.length()][A.length()];
        //i - represent the string
        //j - represent the string
        //now if iand j are same we can form 1 string and that is palindrome
        for(int i=0;i<dp.length;i++){
            dp[i][i] = 1;
        }

        for(int k=2;k<=A.length();k++){
            for(int i=0;i<dp.length-k+1;i++){
                int j = i+k-1;
                if(A.charAt(i) == A.charAt(j) && k==2){
                    dp[i][j] = 2;
                }else if(A.charAt(i) == A.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                    dp[i][j] =  Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }

        return dp[0][A.length()-1];

    }
}
