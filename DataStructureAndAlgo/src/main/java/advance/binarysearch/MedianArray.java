package advance.binarysearch;

import java.util.List;

/**
 * Median of Array
 *
 * Problem Description
 * There are two sorted arrays A and B of sizes N and M respectively.
 *
 * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 *
 * NOTE:
 *
 * The overall run time complexity should be O(log(m+n)).
 * IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
 *
 *
 * Problem Constraints
 * 1 <= N + M <= 2*106
 *
 *
 *
 * Input Format
 * The first argument is an integer array A of size N.
 * The second argument is an integer array B of size M.
 *
 *
 *
 * Output Format
 * Return a decimal value denoting the median of two sorted arrays.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 5]
 *  B = [2, 3]
 * Input 2:
 *
 *  A = [1, 2, 3]
 *  B = [4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  3.0
 * Output 2:
 *
 *  2.5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The median of both the sorted arrays will be 3.0.
 * Explanation 2:
 *
 *  The median of both the sorted arrays will be (2+3)/2 = 2.5.
 *
 *  Good Explanation available : https://www.youtube.com/watch?v=NTop3VTjmxk
 */
public class MedianArray {

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        //We will always use the first array as the smaller array
        if(a.size()>b.size()){
            return findMedianSortedArrays(b,a);
        }
        //Need to form a partition causing two cut point

        int n1 = a.size();
        int n2 = b.size();
        int low = 0;
        int high = a.size();

        while(low<=high){
            int cut1 = (high+low)>>1; //Binary operation to divide a number by 2
            int cut2 = (n1+n2+1)/2 - cut1;

            int left1 = cut1==0 ? Integer.MIN_VALUE : a.get(cut1-1);
            int left2 = cut2==0 ? Integer.MIN_VALUE : b.get(cut2-1);

            int right1 = cut1==n1 ? Integer.MAX_VALUE : a.get(cut1);
            int right2 = cut2==n2 ? Integer.MAX_VALUE : b.get(cut2);

            if(left1<=right2 && left2<=right1){
                if((n1+n2)%2 == 0){
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0;
                }else {
                    return Math.max(left1,left2);
                }
            }else if(left1>right2){
                high = cut1-1;
            }else{
                low = cut1+1;
            }
        }

        return 0.0;

    }
}
