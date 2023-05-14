package advance.sorting;

import java.util.ArrayList;

/**
 * Maximum Unsorted Subarray
 * Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 * First and only argument is an array of non-negative integers of size N.
 *
 *
 *
 * Output Format
 * Return an array of length two where the first element denotes the starting index(0-based) and the second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 3, 2, 4, 5]
 * Input 2:
 *
 * A = [1, 2, 3, 4, 5]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 2]
 * Output 2:
 *
 * [-1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * If we sort the sub-array A1, A2, then the whole array A gets sorted.
 * Explanation 2:
 *
 * A is already sorted.
 *
 */
public class MaximumUnsortedSubArray {

    int minIndex = Integer.MAX_VALUE;
    int maxIndex = Integer.MIN_VALUE;
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        mergeSort(A,0,A.size()-1);
        ArrayList<Integer> result = new ArrayList<>();
        if(minIndex == Integer.MAX_VALUE){
            result.add(-1);
        }else{
            result.add(minIndex);
            result.add(maxIndex);
        }
        return result;
    }

    public void mergeSort(ArrayList<Integer> A, int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(A,left,mid);
        mergeSort(A,mid+1,right);
        merge(A,left,right);
    }

    public void merge(ArrayList<Integer> A,int left, int right){
        int mid = (left+right)/2;
        int i = left;
        int j = mid+1;
        ArrayList<Integer> tempList = new ArrayList<>();
        while(i<=mid && j<=right){
            if(A.get(i)>A.get(j)){
                minIndex = Math.min(minIndex,i);
                maxIndex = Math.max(maxIndex,j);
                tempList.add(A.get(j));
                j++;
            }else{
                tempList.add(A.get(i));
                i++;
            }
        }
        while(i<=mid){
            tempList.add(A.get(i));
            i++;
        }
        while(j<=right){
            tempList.add(A.get(j));
            j++;
        }
        int k=0;
        for(i=left;i<=right;i++,k++){
            A.set(i,tempList.get(k));
        }
    }
}
