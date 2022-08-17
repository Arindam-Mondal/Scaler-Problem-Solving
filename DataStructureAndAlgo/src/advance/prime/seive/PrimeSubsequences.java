package advance.prime.seive;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Prime Subsequences
 *
 * Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.
 *
 * A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.
 *
 *
 *
 * Input Format
 *
 * The first argument given is an Array A, having N integers.
 * Output Format
 *
 * Return an integer X, i.e number of Prime subsequences.
 * As X can be very large print X % (1000000007), here % is modulus operator.
 * Constraints
 *
 * 1 <= N <= 1e3
 * 1 <= A[i] <= 1e6
 * For Example
 *
 * Input:
 *     A = [1, 2, 3]
 * Output:
 *      3
 *
 * Explanation:
 *     no. Subsequences      Prime subsequences
 *     1.  [1]                     No
 *     2.  [1, 2]                  No
 *     3.  [1, 3]                  No
 *     4.  [1, 2, 3]               No
 *     5.  [2]                     Yes
 *     6.  [2, 3]                  Yes
 *     7.  [3]                     Yes
 *     8.  []                      No
 *
 *     here we have 3 subsequences(5, 6, 7) those have only prime number(s).
 *
 */
public class PrimeSubsequences {

    public int solve(ArrayList<Integer> A) {
        //Step 1
        //Find the seive
        int n = 1000000;
        int mod = 1000000007;
        boolean[] seive = new boolean[n+1];
        Arrays.fill(seive,true);
        seive[0] = false;
        seive[1] = false;
        for(int i=2;i*i<=n;i++){
            if(seive[i]){
                for(int j=i*i;j<=n;j +=i){
                    seive[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=0;i<A.size();i++){
            if(seive[A.get(i)]){
                count++;
            }
        }

        int result = 0;

        for(int i=0;i<count;i++){
            result = (result%mod  + pow(2,i,mod)%mod)%mod;
        }

        return result;
    }

    public int pow(int A, int B, int C) {
        if(A==0){
            return 0;
        }
        if(B == 0){
            return 1;
        }
        long halfPower = (long)pow(A,B/2,C);
        if(B % 2 == 0){
            return (int)((halfPower%C * halfPower%C) + C)%C;
        }else {
            return (int)((A%C * halfPower%C * halfPower%C)+C)%C;
        }
    }
}
