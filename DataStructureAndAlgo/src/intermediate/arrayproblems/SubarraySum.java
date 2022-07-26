package intermediate.arrayproblems;

import java.util.ArrayList;

/**
 * You are given an integer array A of length N.
 * You have to find the sum of all subarray sums of A.
 * More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
 * A subarray sum denotes the sum of all the elements of that subarray.
 */
public class SubarraySum {
    public static void main(String[] args) {

    }
}

class SubarraySumSolution {
    public Long subarraySum(ArrayList<Integer> A) {
        long TS = 0;
        int N = A.size();
        //(n-i)*(i+1) - this is a mathematical formula based on observation
        for(int i=0;i<A.size();i++){
            long value = (long)(A.get(i));
            TS = TS + (value * (N-i) * (i+1));
        }
        return TS;
    }
}
