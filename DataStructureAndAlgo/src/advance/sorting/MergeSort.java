package advance.sorting;

import java.util.ArrayList;

/**
 *
 *  Array with consecutive elements
 *
 *  Problem Description
 * Given an array of positive integers A, check and return whether the array elements are consecutive or not.
 * NOTE: Try this with O(1) extra space.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return 1 if the array elements are consecutive else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 2, 1, 4, 5]
 * Input 2:
 *
 *  A = [1, 3, 2, 5]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  As you can see all the elements are consecutive, so we return 1.
 * Explanation 2:
 *
 *  Element 4 is missing, so we return 0.
 *
 */
public class MergeSort {
    public int solve(ArrayList<Integer> A) {
        //Sort the list using bubble Sort
        mergeSort(A,0,A.size()-1);
        for(int i=0;i<A.size()-1;i++){
            if(A.get(i+1) != A.get(i) + 1 ) return 0;
        }

        return 1;
    }

    public void mergeSort(ArrayList<Integer> originalArray,int left, int right){
        if(left==right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(originalArray,left,mid);
        mergeSort(originalArray,mid+1,right);
        merge(originalArray,left,mid,mid+1,right);

    }

    public void merge(ArrayList<Integer> originalArray, int l1, int r1, int l2, int r2){
        ArrayList<Integer> tempList = new ArrayList<>();
        int left1 = l1;
        int right1 = r1;
        int left2 = l2;
        int right2 = r2;

        while(left1<=right1 && left2<=right2){
            if(originalArray.get(left1) > originalArray.get(left2)){
                tempList.add(originalArray.get(left2));
                left2++;
            }else {
                tempList.add(originalArray.get(left1));
                left1++;
            }
        }

        while(left1<=right1){
            tempList.add(originalArray.get(left1));
            left1++;
        }

        while(left2<=right2){
            tempList.add(originalArray.get(left2));
            left2++;
        }

        for(int i=l1,k=0;i<=r2;i++,k++){
            originalArray.set(i,tempList.get(k));
        }
    }
}
