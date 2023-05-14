package advance.binarysearch;

import java.util.ArrayList;

/**
 *
 * Special Integer
 *
 * Problem Description
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 *
 * 1 <= B <= 10^9
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
 * Return the maximum value of K (sub array length).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 * B = 130
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Constraints are satisfied for maximal value of 2.
 * Explanation 2:
 *
 * Constraints are satisfied for maximal value of 3.
 */
public class SpecialInteger {
    int ans = 0;
    public int solve(ArrayList<Integer> A, int B) {
        //First find the prefixsum and then use binary search to determine the range.
        long[] ps = new long[A.size()];
        ps[0] = A.get(0);
        for(int i=1;i<A.size();i++){
            ps[i] = ps[i-1] + A.get(i);
        }
        int low = 1;
        int high = A.size();

        while(low<=high){
            int mid = low + (high-low)/2;
            if(check(ps,mid,B)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public boolean check(long[] ps,int range,int B){
        for(int i=0;i<=ps.length-range;i++){
            long sum = i==0 ? ps[i+range-1] : ps[i+range-1] - ps[i-1];
            if(sum>B){
                return false;
            }
        }
        ans = range;
        return true;
    }
}
