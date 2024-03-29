package advance.modular;

import java.util.ArrayList;

/**
 *  Pair Sum divisible by M
 *
 * Problem Description
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 *
 * Since the answer may be large, return the answer modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 106
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 2
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 28
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
 *  All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
 *  So total 4 pairs.
 *
 */
public class PairSumDivisibleByM {
    public int solve(ArrayList<Integer> A, int B) {
        //find the mod and store it in an array
        long[] arrayMap = new long[B];
        long mod = 1000000007;
        for(int i=0;i<A.size();i++){
            arrayMap[A.get(i)%B]++;
        }
        // System.out.println(arrayMap[0]);
        // System.out.println(arrayMap[1]);

        int mid = B % 2 == 0 ? B/2 : B/2 + 1;

        long ans = (arrayMap[0] * (arrayMap[0] - 1))/2;
        // System.out.println(ans);

        for(int i=1;i<mid;i++){
            ans = ans + (arrayMap[i] * arrayMap[B-i]);
        }

        if(B%2 ==0){
            ans = ans + (arrayMap[mid] * (arrayMap[mid] -1))/2;
        }

        return (int)(ans%mod);
    }
}
