package advance.sorting;

import java.util.ArrayList;

/**
 * Sum the Difference
 *
 * Problem Description
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1<= A[i] <=1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the output.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2]
 * Input 2:
 *
 * A = [1]
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
 * All possible non-empty subsets are:
 * [1]    largest-smallest = 1 - 1 = 0
 * [2]    largest-smallest = 2 - 2 = 0
 * [1 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 * Explanation 2:
 *
 *  Only 1 subsequence of 1 element is formed.
 *
 *  Solved Using the formula
 *
 *  max - min
 *
 *  max = 2^3d + 2^2c + 2^1b + a
 *  min = 2^3a + 2^2b + 2^1c + d
 *
 *  https://www.scaler.com/academy/mentee-dashboard/class/31771/assignment/problems/453/?navref=cl_pb_nv_tb
 */
public class SumTheDifference {

    public int solve(ArrayList<Integer> A) {
        quicksort(A,0,A.size()-1);
        long max = 0;
        long min = 0;
        int mod = 1000000007;
        for(int i=0;i<A.size();i++){
            min = (min * 2L)%mod;
            min = (min%mod + A.get(i)%mod)%mod;
        }
        for(int i=A.size()-1;i>=0;i--){
            max = (max*2L)%mod;
            max = (max%mod + A.get(i)%mod)%mod;
        }
        return (int)(max-min + mod)%mod;
    }

    public void quicksort(ArrayList<Integer> A, int l, int r){
        if(l>=r){
            return;
        }
        int index = merge(A,l,r);
        quicksort(A,l,index-1);
        quicksort(A,index+1,r);
    }

    //taking the first element as the pivot element
    public int merge(ArrayList<Integer> A,int l, int r){
        int i = l+1;
        int j = r;
        int pivot = A.get(l);

        while(i<=j){
            if(A.get(i)<=pivot){
                i++;
            }else if(A.get(j)>pivot){
                j--;
            }else {
                //swap i and j
                swap(A,i,j);
                i++;
                j--;
            }
        }
        swap(A,i-1,l);
        return i-1;
    }

    public void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }
}
