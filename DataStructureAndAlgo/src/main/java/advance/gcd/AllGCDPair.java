package advance.gcd;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * All GCD Pair
 *
 * Problem Description
 * Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
 *
 * Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Find and return the original numbers which are used to calculate the GCD array in any order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
 * Input 2:
 *
 *  A = [5, 5, 5, 15]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 8, 10]
 * Output 2:
 *
 *  [5, 15]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 *  2 is the gcd between 2 and 8, 2 and 10.
 *  8 and 10 are the gcds pair with itself.
 *  Therefore, [2, 8, 10] is the original array.
 * Explanation 2:
 *
 *  Initially, array A = [5, 5, 5, 15].
 *  5 is the gcd between 5 and 15.
 *  15 is the gcds pair with itself.
 *  Therefore, [5, 15] is the original array.
 */
public class AllGCDPair {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> gcdMap = new HashMap<>();
        A.sort((a,b)->b.compareTo(a));
        // System.out.println(A);
        for(int i=0;i<A.size();i++){
            if(gcdMap.containsKey(A.get(i)) && gcdMap.get(A.get(i)) != 0){
                int count = gcdMap.get(A.get(i));
                gcdMap.put(A.get(i),count-1);
            }else{
                result.add(A.get(i));
                for(int j=0;j<i;j++){
                    //find gcd
                    int gcd = findGCD(A.get(j),A.get(i));
                    int count = gcdMap.containsKey(gcd) ? gcdMap.get(gcd) : 0;
                    count = count + 2;
                    gcdMap.put(gcd,count);
                }
            }
        }
        return result;
    }

    public int findGCD(int a,int b){
        int x = Math.min(a,b);
        int y = Math.max(a,b);
        int ans = 1;
        for(int i=1;i*i<=x;i++){
            if(x%i == 0){
                if(y%i == 0) {
                    ans = Math.max(ans,i);
                }
                if(y%(x/i) == 0){
                    ans = Math.max(ans,x/i);
                }
            }
        }
        return ans;
    }
}
