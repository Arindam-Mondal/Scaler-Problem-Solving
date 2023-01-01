package advance.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * Russian Doll Envelopes
 *
 * Problem Description
 * Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * Find the maximum number of envelopes you can put one inside other.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 * 1 <= A[i][0], A[i][1] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of envelopes you can put one inside other.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *          [5, 4]
 *          [6, 4]
 *          [6, 7]
 *          [2, 3]
 *      ]
 * Input 2:
 *
 *  A = [     '
 *          [8, 9]
 *          [8, 18]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Step 1: put [2, 3] inside [5, 4]
 *  Step 2: put [5, 4] inside [6, 7]
 *  3 envelopes can be put one inside other.
 * Explanation 2:
 *
 *  No envelopes can be put inside any other so answer is 1.
 *
 */
public class LongestIncreasingSubsequence {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        //Solving using Longest Increasing Subsequence problem
        //Follow the approach of take or not take
        //first sort the array based on height
        Collections.sort(A,(a, b)->a.get(0)-b.get(0));
        //Once A is sorted based on increasing order of height, now need to apply Longest Increasing Subsequence on the width
        int[][] dp = new int[A.size()][A.size()+1];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        return russianDoll(A,0,-1,dp);
    }

    public int russianDoll(ArrayList<ArrayList<Integer>> A,int idx,int prevIdx,int[][] dp){
        //if idx == A.size() -> terminate
        if(idx == A.size()){
            return 0;
        }
        if(dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1];
        }
        //there can be two condition -
        //1. Donot take
        int len = 0 + russianDoll(A,idx+1,prevIdx,dp);
        //2. Take - if taken - it has to be in ncreasing order of width
        if(prevIdx == -1 || A.get(idx).get(0)>A.get(prevIdx).get(0) && A.get(idx).get(1)>A.get(prevIdx).get(1)){
            len = Math.max(len,1+russianDoll(A,idx+1,idx,dp));
        }

        dp[idx][prevIdx+1] = len;
        return len;

    }
}
