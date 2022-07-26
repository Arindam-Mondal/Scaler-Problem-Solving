package intermediate.arrayproblems;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an array of size N, find the subarray of size K with the least average.
 *
 *
 *
 * Problem Constraints
 * 1<=k<=N<=1e5
 * -1e5<=A[i]<=1e5
 *
 *
 * Input Format
 * First argument contains an array A of integers of size N.
 * Second argument contains integer k.
 *
 *
 * Output Format
 * Return the index of the first element of the subarray of size k that has least average.
 * Array indexing starts from 0.
 *
 *
 * Example Input
 * Input 1:
 * A=[3, 7, 90, 20, 10, 50, 40]
 * B=3
 * Input 2:
 *
 * A=[3, 7, 5, 20, -10, 0, 12]
 * B=2
 *
 *
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 * Subarray between indexes 3 and 5
 * The subarray {20, 10, 50} has the least average
 * among all subarrays of size 3.
 * Explanation 2:
 *
 *  Subarray between [4, 5] has minimum average
 */
public class SubarrayWithLeastAverage {
    public static void main(String[] args) {
        //Write the logic to
        SubarrayWithLeastAverageSolution sol = new SubarrayWithLeastAverageSolution();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(12);
        inputList.add(8);
        inputList.add(1);
        inputList.add(2);
        inputList.add(9);
        inputList.add(5);
        System.out.println(sol.solve(inputList,5));
        System.out.println();
    }
}

class SubarrayWithLeastAverageSolution {
    public int solve(ArrayList<Integer> A, int B) {
        int LA = Integer.MAX_VALUE;
        int MI = 0;
        int[] PS = new int[A.size()];
        PS[0] = A.get(0);
        for(int i=1;i<PS.length;i++){
            PS[i] = PS[i-1] + A.get(i);
        }
        for(int i=0;i<=A.size()-B;i++){
            //Only finding the prefix sum would suffice as the B is constant here so no need tdivide it again.
            int average = 0;
            if (i == 0) {
                average = PS[i+B-1];
            }else {
                average = (PS[i+B-1] - PS[i-1]);
            }

            if(LA>average){
                LA = average;
                MI = i;
            }
        }
        return MI;
    }
}
