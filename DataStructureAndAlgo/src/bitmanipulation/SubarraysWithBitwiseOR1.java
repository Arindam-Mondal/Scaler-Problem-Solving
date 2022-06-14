package bitmanipulation;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an array B of length A with elements 1 or 0. Find the number of subarrays with bitwise OR 1.
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 * Input Format
 * The first argument is a single integer A.
 * The second argument is an integer array B.
 *
 *
 * Output Format
 * Return the number of subarrays with bitwise array 1.
 *
 *
 * Example Input
 * Input 1:
 *  A = 3
 * B = [1, 0, 1]
 * Input 2:
 *  A = 2
 * B = [1, 0]
 *
 *
 * Example Output
 * Output 1:
 * 5
 * Output2:
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 * The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
 * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 * Explanation 2:
 * The subarrays are :- [1], [0], [1, 0]
 * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 */

/**
 * Borrowed the logic from below:
 *
 * Example: 0 0 1 1 0 1
 *     subarrays starting at each index
 *     0 → [0] [0,0] [0,0,1] [0,0,1,1] [0,0,1,1,0] [0,0,1,1,0,1] → Valid subarrays 4
 *     1 → [0] [0,1] [0,1,1] [0,1,1,0] [0,1,1,0,1] → Valid subarrays 4
 *     2 → [1] [1,1] [1,1,0] [1,1,0,1] → Valid subarrays 4
 *     3 → [1] [1,0] [1,0,1] → Valid subarrays 3
 *     4 → [0] [0,1] → Valid subarrays 1
 *     5 → [1] → Valid subarrays 1
 *
 *     Observation:
 *     1. All sub array with at least one 1 satisfies our condition of OR.
 *     2. subarrays containing only 0’s will not satisfy our OR condition.
 *     3. From our subarrays topic no.of subarrays starting at index i is N-i.
 *     4. count of valid subarrays that start at index i where B[i] is 1 is N-i
 *     5. count of valid subarrays that start at index i where B[i] is 0 is count of valid subarrays from index j where j>i and B[j] is 1;
 *
 *
 *     Approach: iterate from right to left if B[i] is 1 then valid subarrays is N-i
 *     if B[i] is 0 then valid subarrays is valid subarrays from j where j>i and B[j] = 1
 *
 *     Reference: carry forward the valid subarrays
 */
public class SubarraysWithBitwiseOR1 {
    public Long solve(int A, ArrayList<Integer> B) {
        Long noOfSubArray = 0L;
        Long noOfSubArrayOne = 0L;
        int i = A-1;
        while(i>=0){
            if(B.get(i) == 1){
                noOfSubArrayOne = (long)A-i;
                noOfSubArray = noOfSubArray + noOfSubArrayOne;
            }else{
                noOfSubArray = noOfSubArray + noOfSubArrayOne;
            }
            i--;
        }
        return noOfSubArray;
    }
}
