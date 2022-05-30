package ArrayProblems;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
 *and at least one occurrence of the minimum value of the array.
 *
 * Problem Constraints
 * 1 <= |A| <= 2000
 *
 * Input Format
 * First and only argument is vector A
 *
 * Output Format
 * Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 3]
 * Input 2:
 *
 * A = [2]
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Only choice is to take both elements.
 * Explanation 2:
 *
 *  Take the whole array.
 */
public class ClosestMinMax {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(2);
        inputList.add(8);
        inputList.add(1);
        inputList.add(2);
        inputList.add(9);
        inputList.add(5);
        System.out.println(sol.solve(inputList));
    }
}

class Solution {
    public int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;

        for(int i=0;i<A.size();i++){
            if(max<A.get(i)) {
                max = A.get(i);
            }
            if(min > A.get(i)) {
                min = A.get(i);
            }
        }
        int R = A.size();
        int MAX_I = -1;
        int MIN_I = -1;

        for(int i=0;i<A.size();i++){
            if(A.get(i) == max) {
                MAX_I = i;
            }
            if(A.get(i) == min) {
                MIN_I = i;
            }
            if(MAX_I != -1 && MIN_I != -1) {
                R = R < Math.abs(MAX_I - MIN_I) + 1 ? R : Math.abs(MAX_I - MIN_I) + 1;
            }
        }

        return R;
    }
}
