package intermediate.arrayproblems;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an array A of N non-negative numbers and a non-negative number B,
 * you need to find the number of subarrays in A with a sum less than B.
 * We may assume that there is no overflow.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 103
 *
 * 1 <= A[i] <= 1000
 *
 * 1 <= B <= 107
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of subarrays in A having sum less than B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 5, 6]
 *  B = 10
 * Input 2:
 *
 *  A = [1, 11, 2, 3, 15]
 *  B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
 * Explanation 2:
 *
 *  The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 */
public class CountingSubarraysEasy {
    public static void main(String[] args) {
        CountingSubarraysEasySolution sol = new CountingSubarraysEasySolution();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(12);
        inputList.add(8);
        inputList.add(1);
        inputList.add(2);
        inputList.add(9);
        inputList.add(5);
        System.out.println(sol.solve(inputList,5));
    }
}

class CountingSubarraysEasySolution {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        //Find Prefix sum and then check the sum from any two index by iterating over two loops and find the max sum which is less than B
        int[] PS = new int[A.size()];
        PS[0] = A.get(0);
        for(int i=1;i<PS.length;i++){
            PS[i] = PS[i-1] + A.get(i);
        }
        for(int i=0;i<A.size();i++){
            for(int j=i;j<A.size();j++){
                int sum = 0;
                if(i==0){
                    sum = PS[j];
                }else {
                    sum = PS[j] - PS[i-1];
                }
                if(B>sum) {
                    count++;
                }
            }
        }
        return count;
    }
}
