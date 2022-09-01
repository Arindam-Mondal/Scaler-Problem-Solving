package advance.binarysearch;

import java.util.ArrayList;

/**
 * Sorted Insert Position
 *
 * Problem Description
 * Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 *
 *
 * Input Format
 * The first argument is an integer array A of size N.
 * The second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the index of target value.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 3, 5, 6]
 * B = 5
 * Input 2:
 *
 * A = [1]
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The target value is present at index 2.
 * Explanation 2:
 *
 * The target value is present at index 0.
 *
 * https://www.scaler.com/academy/mentee-dashboard/class/31774/assignment/problems/204/?navref=cl_pb_nv_tb
 */
public class SortedInsertPosition {

    public int searchInsert(ArrayList<Integer> A, int B) {

        int l=0;
        int r = A.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(B == A.get(mid)){
                return mid;
            }else if(B < A.get(mid)){
                r = mid-1;
            }else if(B > A.get(mid)){
                if(mid == A.size()-1 || A.get(mid+1) > B){
                    return mid+1;
                }
                l=mid+1;
            }
        }
        return l;
    }
}
