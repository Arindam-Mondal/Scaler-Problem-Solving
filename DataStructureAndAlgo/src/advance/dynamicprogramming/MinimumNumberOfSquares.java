package advance.dynamicprogramming;

/**
 * Minimum Number of Squares
 *
 * Problem Description
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 * First and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum count.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 6
 * Input 2:
 *
 *  A = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 *  Minimum count of numbers, sum of whose squares is 6 is 3.
 * Explanation 2:
 *
 *  We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */
public class MinimumNumberOfSquares {
    public int countMinSquares(int A) {
        int[] memo = new int[A+1];
        // System.out.print(memo[13]);
        return helper(A,memo);
    }

    public int helper(int A,int[] memo){
        // System.out.println(A);
        if(memo[A]!=0){
            return memo[A];
        }
        int squareRoort = (int)Math.sqrt(A);
        if((squareRoort * squareRoort) == A){
            return 1;
        }

        int i=1;
        int ans = Integer.MAX_VALUE;
        while((i*i) <= A){
            ans = Math.min(ans,1+helper((A-(i*i)),memo));
            i++;
        }
        memo[A] = ans;
        return ans;
    }
}
