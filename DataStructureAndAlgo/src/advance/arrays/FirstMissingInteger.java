package advance.arrays;

import java.util.ArrayList;

/**
 * First Missing Integer
 * Solved
 * character backgroundcharacter
 * Stuck somewhere?
 * Ask for help from a TA and get it resolved.
 * Get help from TA.
 * Problem Description
 * Given an unsorted integer array, A of size N. Find the first missing positive integer.
 *
 * Note: Your algorithm should run in O(n) time and use constant space.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the first missing positive integer.
 */
public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        for(int i=0;i<n;){
            // System.out.println(i);
            if(A.get(i) == i+1 || A.get(i) < 1 || A.get(i) > A.size() || A.get(i) == A.get(A.get(i)-1)){
                i++;
            }else {
                //swap
                int temp = A.get(i);
                A.set(i,A.get(A.get(i)-1));
                A.set(temp-1, temp);
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(A.get(i) + " ");
        // }
        for(int i=0;i<n;i++){
            if(A.get(i) != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
