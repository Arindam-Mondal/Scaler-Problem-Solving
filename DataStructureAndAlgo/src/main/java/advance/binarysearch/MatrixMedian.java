package advance.binarysearch;

import java.util.ArrayList;

/**
 * Matrix Median
 *
 * Problem Description
 * Given a matrix of integers A of size N x M in which each row is sorted.
 *
 * Find and return the overall median of matrix A.
 *
 * NOTE: No extra memory is allowed.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 10^5
 *
 * 1 <= N*M <= 10^6
 *
 * 1 <= A[i] <= 10^9
 *
 * N*M is odd
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the overall median of matrix A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [1, 3, 5],
 *         [2, 6, 9],
 *         [3, 6, 9]   ]
 * Input 2:
 *
 * A = [   [5, 17, 100]    ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  17
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * Median is 5. So, we return 5.
 * Explanation 2:
 *
 * Median is 17.
 */
public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        //The idea here is to leverage the binary search algorithm in order to optimize this problem.
        //For odd elements the median is (1+N*M)/2 th smallest number which basically implies that (1+N*M)/2 is the total number of elements which are smaller or equal to our median.
        // One more thing to analyse is, the median will always lie in the range of minimum and maximum element.
        // Using these observations and applying binary search for elements in the above range (minimum, maximum)
        // and maintaing the counter for smaller or equal numbers for each element in this range, we can find our median(discussed above based on count of smaller or equal elements).
        long minSize = (A.size() * A.get(0).size() + 1)/2;
        //Find the min and max from the array
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(A.get(i).get(j)<low){
                    low = A.get(i).get(j);
                }
                if(A.get(i).get(j)>high){
                    high = A.get(i).get(j);
                }
            }
        }


        while(low<=high){
            int mid = low + (high-low)/2;
            //find no of elements less than equato mid
            int count = count(A,mid);
            if(count<minSize){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }

    public int count(ArrayList<ArrayList<Integer>> A, int n){
        int count = 0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(A.get(i).get(j)<=n){
                    count++;
                }
            }
        }
        return count;
    }
}
