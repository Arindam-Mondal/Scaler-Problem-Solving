package advance.binarysearch;

import java.util.List;

/**
 * Rotated Sorted Array Search
 *
 * Problem Description
 * Given a sorted array of integers A of size N and an integer B.
 *
 * array A is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 *
 * You are given a target value B to search. If found in the array, return its index otherwise, return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 *
 * 1 <= A[i] <= 10^9
 *
 * all elements in A are distinct.
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return index of B in array A, otherwise return -1
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Input 2:
 *
 * A = [1]
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *
 * Target 4 is found at index 0 in A.
 * Explanation 2:
 *
 *
 * Target 1 is found at index 0 in A.
 */
public class RotatedSortedArraySearch {
    public int search(final List<Integer> A, int B) {
        // int peakIndex = findPeakIndex(A);
        int peakIndex = findPeakBruteForce(A);
        //now we have two sorted array and we will perform the binary search on both the arrays.
        int searchArrayOne = binarySearch(A,0,peakIndex,B);
        // System.out.println("peakIndex->"+peakIndex);
        int searchArrayTwo = binarySearch(A,peakIndex+1,A.size()-1,B);
        return searchArrayOne == -1 ? searchArrayTwo : searchArrayOne;
    }

    public int findPeakBruteForce(List<Integer> A){
        int i=1;
        for (;i<A.size();i++){
            if(A.get(i)<A.get(i-1)){
                break;
            }
        }
        return i-1;
    }

    public int findPeakIndex(List<Integer> A){
        int l = 0;
        int r = A.size()-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(A.get(mid)>A.get(mid+1)){
                r =mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public int binarySearch(List<Integer> A, int l,int r, int B){
        while(l<=r){
            int mid = l + (r-l)/2;
            if(A.get(mid)==B){
                return mid;
            }else if(B>A.get(mid)){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
}
