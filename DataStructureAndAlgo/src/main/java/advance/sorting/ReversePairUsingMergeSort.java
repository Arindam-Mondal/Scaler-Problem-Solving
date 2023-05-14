package advance.sorting;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
 * Return the number of important reverse pairs in the given array A.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 105
 *
 * -2 * 109 <= A[i] <= 2 * 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the number of important reverse pairs in the given array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 3, 2, 3, 1]
 * Input 2:
 *
 *  A = [4, 1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are two pairs which are important reverse i.e (3, 1) and (3, 1).
 * Explanation 2:
 *
 *  There is only one pair i.e (4, 1).
 */

public class ReversePairUsingMergeSort {
    public int mergeSort(ArrayList<Integer> A, int l, int r){

        if(l==r){
            return 0;
        }
        int mid = (l+r)/2;
        int a = mergeSort(A,l,mid);
        int b = mergeSort(A,mid+1,r);
        int ab = merge(A,l,r);

        return a + b + ab;
    }

    public int merge(ArrayList<Integer> A, int l, int r){
        int mid = (l+r)/2;
        int i=l;
        int j=mid+1;
        int count = 0;
        ArrayList<Integer> sortedList = new ArrayList<>();
        //below is the modified logic in merge sort. rest of the merge sort logic remains same
        while(i<=mid && j<=r){
            if((long)A.get(i)>(long)(2L*A.get(j))){
                count = count + (mid-i) + 1;
                j++;
            }else{
                i++;
            }
        }
        i=l;
        j=mid+1;
        while(i<=mid && j<=r){
            if(A.get(j) > A.get(i)){
                sortedList.add(A.get(i));
                i++;
            }else{
                sortedList.add(A.get(j));
                j++;
            }
        }
        while(i<=mid){
            sortedList.add(A.get(i));
            i++;
        }
        while(j<=r){
            sortedList.add(A.get(j));
            j++;
        }
        for(int k=0;k<sortedList.size();k++,l++){
            A.set(l,sortedList.get(k));
        }

        return count;
    }
}
