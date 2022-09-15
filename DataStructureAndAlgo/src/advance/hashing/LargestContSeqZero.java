package advance.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *  Largest Continuous Sequence Zero Sum
 *
 *  Q4. Largest Continuous Sequence Zero Sum
 * Solved
 * character backgroundcharacter
 * Stuck somewhere?
 * Ask for help from a TA and get it resolved.
 * Get help from TA.
 * Problem Description
 * Given an array A of N integers.
 *
 * Find the largest continuous sequence in a array which sums to zero.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 * -107 <= A[i] <= 107
 *
 *
 *
 * Input Format
 * Single argument which is an integer array A.
 *
 *
 *
 * Output Format
 * Return an array denoting the longest continuous sequence with total sum of zero.
 *
 * NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 *
 *
 *
 * Example Input
 * A = [1,2,-2,4,-4]
 *
 *
 * Example Output
 * [2,-2,4,-4]
 *
 *
 * Example Explanation
 * [2,-2,4,-4] is the longest sequence with total sum of zero.
 */
public class LargestContSeqZero {

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        //Find the prefixSum
        int n = A.size();
        int ps[] = new int[n];
        ps[0] = A.get(0);
        for(int i=1;i<n;i++){
            ps[i] = ps[i-1] + A.get(i);
        }
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        int idx1 = 0;
        int idx2 = -1;
        int maxDistance = -1;
        for(int i=0;i<n;i++){
            int num = ps[i];
            if(frequencyMap.containsKey(num)){
                int distance = i - (frequencyMap.get(num) + 1) + 1;
                if(distance > maxDistance){
                    maxDistance = distance;
                    idx1 = frequencyMap.get(num) + 1;
                    idx2 = i;
                }
            }else{
                frequencyMap.put(num,i);
            }

            if(num == 0){
                int distance = i+1;
                if(distance > maxDistance){
                    maxDistance = distance;
                    idx1 = 0;
                    idx2 = i;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = idx1;i<=idx2;i++){
            result.add(A.get(i));
        }

        return result;
    }
}
