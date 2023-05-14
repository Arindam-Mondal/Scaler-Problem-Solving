package intermediate.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Largest Continuous Sequence Zero Sum
 *
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
public class LargestContinuousSequenceZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        //find prefixSum
        int n = A.size();
        int ps[] = new int[n];
        ps[0] = A.get(0);
        HashMap<Integer,ArrayList<Integer>> fm = new HashMap<>();
        int pos1 = 0;
        int pos2 = 0;
        int length = -1;
        for(int i=1;i<n;i++){
            ps[i] = ps[i-1] + A.get(i);
        }
        for(int i=0;i<n;i++){
            if(ps[i]==0){
                int tempLength = i+1;
                if(length<tempLength){
                    length = tempLength;
                    pos1 = -1;
                    pos2 = i;
                }
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
                int tempLength = positionList.get(positionList.size()-1) - positionList.get(0);
                if(length<tempLength){
                    length = tempLength;
                    pos1 = positionList.get(0);
                    pos2 = positionList.get(positionList.size()-1);
                }
            }
        }

        ArrayList<Integer> rl = new ArrayList<>();
        for(int i= pos1+1 ;i<=pos2;i++){
            rl.add(A.get(i));
        }

        return rl;

    }
}
