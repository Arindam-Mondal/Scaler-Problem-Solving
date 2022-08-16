package advance.prime.seive;

import java.util.ArrayList;

/**
 * Count of divisors
 *
 * Problem Description
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 *
 * NOTE: The order of the resultant array should be the same as the input array.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the count of divisors of each element of the array in the form of an array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 3, 4, 5]
 * Input 2:
 *
 *  A = [8, 9, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 2, 3, 2]
 * Output 1:
 *
 *  [4, 3, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 *  So the count will be [2, 2, 3, 2].
 * Explanation 2:
 *
 *  The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 *  So the count will be [4, 3, 4].
 */
public class CountOfDivisors {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        // find the max element from the array
        // intmax = 0;
        //Using Seive
        int n = 1000000;
        int[] seive = new int[n+1];
        for(int i=0;i<=n;i++){
            seive[i] = i;
        }
        for(int i=2;i*i<=n;i++){
            if(seive[i] == i){
                for(int j=i*i;j<=n; j += i){
                    if(seive[j] == j){
                        seive[j] = i;
                    }
                }
            }
        }

        ArrayList<Integer> divisorCount = new ArrayList<>();

        for(int i=0;i<A.size();i++){
            int N = A.get(i);
            int count = 1;
            while(N>1){
                int spf = seive[N];
                int tempCount = 0;
                while(spf == seive[N]){
                    N = N/seive[N];
                    tempCount++;
                }
                count = count * (tempCount + 1);
            }
            divisorCount.add(count);
        }

        return divisorCount;
    }
}
