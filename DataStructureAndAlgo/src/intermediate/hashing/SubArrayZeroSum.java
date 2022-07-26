package intermediate.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Sub-array with 0 sum
 *
 * Problem Description
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * -10^9 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return whether the given array contains a subarray with a sum equal to 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [-1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  No subarray has sum 0.
 * Explanation 2:
 *
 *  The array has sum 0.
 */
public class SubArrayZeroSum {
    public int solve(ArrayList<Integer> A) {
        //find prefixSum
        int n = A.size();
        long ps[] = new long[n];
        ps[0] = (long)A.get(0);
        HashMap<Long,ArrayList<Integer>> fm = new HashMap<>();
        int result = 0;
        for(int i=1;i<n;i++){
            ps[i] = ps[i-1] + (long)A.get(i);
        }
        for(int i=0;i<n;i++){
            if(ps[i]==0){
                return 1;
            }
            ArrayList<Integer> positionList = new ArrayList<>();
            if(fm.containsKey(ps[i])){
                positionList = fm.get(ps[i]);
                positionList.add(i);
                fm.put(ps[i],positionList);
            }else{
                positionList.add(i);
                fm.put(ps[i],positionList);
            }
            if(positionList.size()>1){
                return 1;
            }
        }

        return 0;
    }
}
