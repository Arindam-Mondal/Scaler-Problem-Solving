package intermediate.subsetandsubsequence;

import java.util.ArrayList;

/**
 *  Sum the Difference
 *
 *  Problem Description
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1<= A[i] <=1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the output.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2]
 * Input 2:
 *
 * A = [1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All possible non-empty subsets are:
 * [1]    largest-smallest = 1 - 1 = 0
 * [2]    largest-smallest = 2 - 2 = 0
 * [1 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 * Explanation 2:
 *
 *  Only 1 subsequence of 1 element is formed.
 */
public class SumTheDifference {

    public int solve(ArrayList<Integer> A) {
        int MOD = 1000000007;
        int max_sum = 0;
        int min_sum = 0;
        int n = A.size();
        A.sort((a,b)->a.compareTo(b));
        // horner's rule calc max_sum and min_sum
        //TODO Need to understand the derivation for Horner's rule.
        for(int i=0 ;i<n;i++){
            max_sum = 2 * max_sum + A.get(n-1-i);
            max_sum = max_sum % MOD;
            min_sum = 2 * min_sum + A.get(i);
            min_sum = min_sum % MOD;
        }
        return (max_sum - min_sum + MOD) % MOD;
    }
}
