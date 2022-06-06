package arrayproblems;

import java.util.ArrayList;

/**
 * Problem Description
 * You are given an integer array A.
 *
 * Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.
 *
 * Return "YES" if it is possible; otherwise, return "NO" (without quotes).
 *
 *
 *
 * Problem Constraints
 * 1 <= |A|, A[i] <= 106
 *
 *
 *
 * Input Format
 * The first and the only input argument is an integer array, A.
 *
 *
 *
 * Output Format
 * Return a string "YES" or "NO" denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 4, 8, 6]
 * Input 2:
 *
 *  A = [2, 4, 8, 7, 6]
 *
 *
 * Example Output
 * Output 1:
 *
 *  "YES"
 * Output 2:
 *
 *  "NO"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can divide A into [2, 4] and [8, 6].
 * Explanation 2:
 *
 *  There is no way to divide the array into even length subarrays.
 */
public class EvenSubarrays {
    public static void main(String[] args) {
        EvenSubarraysSolution evenSubarraysSolution = new EvenSubarraysSolution();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(2);
        inputList.add(8);
        inputList.add(1);
        inputList.add(2);
        inputList.add(9);
        inputList.add(5);
        System.out.println(evenSubarraysSolution.solve(inputList));
    }
}

/**
 * Solved using recursion.
 * If checking if the length of the array is odd. If it's odd then it's not possible to divide the array into subarrays of even length.
 * Dividing the array into halves and cheching if the first and last element are even.
 */
class EvenSubarraysSolution {
    public String solve(ArrayList<Integer> A) {
        if(A.size() % 2 != 0) return "NO";
        if(checkEvenSubArray(A,0,A.size()-1)) return "YES";
        else return "NO";

    }

    public Boolean checkEvenSubArray(ArrayList<Integer> A, int start, int end) {
        if(start == end) {
            if(A.get(start) % 2 == 0) return true;
            return false;
        }
        if (A.get(start) % 2 == 0 && A.get(end) % 2 == 0) {
            return true;
        } else {
            int mid = (end+start)/2;
            return (checkEvenSubArray(A,start,mid) && checkEvenSubArray(A,mid + 1,end));
        }
    }
}
