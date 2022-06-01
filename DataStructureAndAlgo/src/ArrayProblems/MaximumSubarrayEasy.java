package ArrayProblems;

import java.util.ArrayList;

/**
 * Problem Description
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
 * But the sum must not exceed B.
 *
 *
 * Problem Constraints
 * 1 <= A <= 103
 * 1 <= B <= 109
 * 1 <= C[i] <= 106
 *
 *
 * Input Format
 * The first argument is the integer A.
 * The second argument is the integer B.
 * The third argument is the integer array C.
 *
 *
 * Output Format
 * Return a single integer which denotes the maximum sum.
 *
 *
 * Example Input
 * Input 1:
 * A = 5
 * B = 12
 * C = [2, 1, 3, 4, 5]
 * Input 2:
 *
 * A = 3
 * B = 1
 * C = [2, 2, 2]
 *
 *
 * Example Output
 * Output 1:
 * 12
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 * We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
 * Explanation 2:
 *
 * All elements are greater than B, which means we cannot select any subarray.
 * Hence, the answer is 0.
 */
public class MaximumSubarrayEasy {

    public static void main(String[] args) {
        MaximumSubarrayEasySolution sol = new MaximumSubarrayEasySolution();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(12);
        inputList.add(8);
        inputList.add(1);
        inputList.add(2);
        inputList.add(9);
        inputList.add(5);
        System.out.println(sol.maxSubarray(6,5,inputList));
        System.out.println();
    }
}


class MaximumSubarrayEasySolution {
    public int maxSubarray(int A, int B, ArrayList<Integer> C) {
        int maxSum = 0;
        //Find Prefix sum and then check the sum from any two index by iterating over two loops and find the max sum which is less than B
        int[] PS = new int[C.size()];
        PS[0] = C.get(0);
        for(int i=1;i<PS.length;i++){
            PS[i] = PS[i-1] + C.get(i);
        }
        for(int i=0;i<A;i++){
            for(int j=i;j<A;j++){
                int sum = 0;
                if(i==0){
                    sum = PS[j];
                }else {
                    sum = PS[j] - PS[i-1];
                }
                if(maxSum<sum && B>=sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
