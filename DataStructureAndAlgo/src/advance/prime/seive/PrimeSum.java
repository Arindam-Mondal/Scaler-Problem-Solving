package advance.prime.seive;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Prime Sum
 *
 * Problem Description
 * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
 *
 * If there is more than one solution possible, return the lexicographically smaller solution.
 *
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
 * [a, b] < [c, d], If a < c OR a==c AND b < d.
 * NOTE: A solution will always exist. Read Goldbach's conjecture.
 *
 *
 *
 * Problem Constraints
 * 4 <= A <= 2*107
 *
 *
 *
 * Input Format
 * First and only argument of input is an even number A.
 *
 *
 *
 * Output Format
 * Return a integer array of size 2 containing primes whose sum will be equal to given number.
 *
 *
 *
 * Example Input
 *  4
 *
 *
 * Example Output
 *  [2, 2]
 *
 *
 * Example Explanation
 *  There is only 1 solution for A = 4.
 */
public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {
        //First of all find all the prime nos
        boolean[] seive = new boolean[A+1];
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.fill(seive,true);
        seive[0] = false;
        seive[1] = false;
        for(int i=2;i*i<=A;i++){
            if(seive[i] == true){
                for(int j=i*i;j<=A;j += i){
                    seive[j] = false;
                }
            }
        }

        for(int i=2;i<=A;i++){
            if(seive[i] && seive[A-i]){
                result.add(i);
                result.add(A-i);
                break;
            }
        }

        return result;
    }
}
