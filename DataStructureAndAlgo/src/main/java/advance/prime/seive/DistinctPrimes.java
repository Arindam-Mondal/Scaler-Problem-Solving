package advance.prime.seive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Distinct Primes
 *
 * You have given an array A having N integers. Let say G is the product of all elements of A.
 *
 * You have to find the number of distinct prime divisors of G.
 *
 *
 *
 * Input Format
 *
 * The first argument given is an Array A, having N integers.
 * Output Format
 *
 * Return an Integer, i.e number of distinct prime divisors of G.
 * Constraints
 *
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e5
 * For Example
 *
 * Input:
 *     A = [1, 2, 3, 4]
 * Output:
 *      2
 *
 * Explanation:
 *     here G = 1 * 2 * 3 * 4 = 24
 *     and distinct prime divisors of G are [2, 3]
 *
 */
public class DistinctPrimes {
    public int solve(ArrayList<Integer> A) {
        //First create the seive;
        int[] seive = new int[100001];
        for(int i=0;i<seive.length;i++){
            seive[i] = i;
        }
        for(int i=2;i*i<seive.length;i++){
            for(int j=i*i;j<seive.length;j += i){
                if(seive[j]==j){
                    seive[j] = i;
                }
            }
        }
        Set<Integer> resultSet = new HashSet<>();
        for(int i=0;i<A.size();i++){
            int x = A.get(i);
            while(x!=1){
                resultSet.add(seive[x]);
                x = x/seive[x];
            }
        }

        return resultSet.size();
    }
}
