package advance.sorting;

import java.util.ArrayList;

/**
 *  Inversion count in an array
 *
 *  Problem Description
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 *
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
 * Return the number of inversions of A modulo (109 + 7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [3, 2, 1]
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All pairs are inversions.
 * Explanation 2:
 *
 *  No inversions.
 */
public class InversionCountUsingMergeSort {
    public int solve(ArrayList<Integer> A) {
        int x = inversionCount(A,0,A.size()-1);
        // for(int k=0;k<A.size();k++){
        //     System.out.print(A.get(k)+" ");
        // }
        return x;
    }

    public int inversionCount(ArrayList<Integer> A,int l,int r){
        if(l==r){
            return 0;
        }
        int mod = 1000000007;
        int mid = (l+r)/2;
        int a = inversionCount(A,l,mid);
        int b = inversionCount(A,mid+1,r);
        int ab = inversionCountMerge(A,l,r);
        return (a%mod + b%mod + ab%mod)%mod;
    }

    public int inversionCountMerge(ArrayList<Integer> A, int l, int r){
        int mid = (l+r)/2;
        int i = l;
        int j = mid+1;
        int count = 0;
        ArrayList<Integer> tempList = new ArrayList<>();
        while(i<=mid && j<=r){
            if(A.get(i)<=A.get(j)){
                tempList.add(A.get(i));
                i++;
            }else{
                tempList.add(A.get(j));
                count = count + (mid-i+1);
                j++;
            }
        }

        while(i<=mid){
            tempList.add(A.get(i));
            i++;
        }

        while(j<=r){
            tempList.add(A.get(j));
            j++;
        }

        for(int k=0;k<tempList.size();k++,l++){
            A.set(l,tempList.get(k));
        }

        return count;
    }
}
