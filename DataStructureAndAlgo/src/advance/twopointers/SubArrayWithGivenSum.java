package advance.twopointers;

import java.util.ArrayList;

/**
 * Subarray with given sum
 *
 * Problem Description
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single element "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 * Explanation 2:
 *
 *  No subarray sums up to required number.
 */
public class SubArrayWithGivenSum {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> subArray = new ArrayList<>();
        if(A.size() == 1){
            subArray.add(-1);
            return subArray;
        }
        //Find PrefixSum
        int[] ps = new int[A.size()];
        ps[0] = A.get(0);
        for(int i=1;i<A.size();i++){
            ps[i] = ps[i-1] + A.get(i);
        }
        int i = 0;
        int j = 1;
        boolean found = false;

        while(j<ps.length){
            int diff = diff(ps,i,j);
            if(diff == B){
                found = true;
                break;
            }
            if(diff > B){
                i++;
            }else if(diff < B){
                j++;
            }else{
                i++;j++;
            }
        }


        if(!found){
            subArray.add(-1);
        }else{
            for(int k=i;k<=j;k++){
                subArray.add(A.get(k));
            }
        }
        return subArray;
    }

    public int diff(int[] ps, int i, int j){
        if(i==0){
            return ps[j];
        }else{
            return ps[j] - ps[i-1];
        }
    }
}
