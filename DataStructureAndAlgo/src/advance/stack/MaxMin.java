package advance.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * MAX and MIN
 *
 * Problem Description
 * Given an array of integers A.
 *
 * value of a array = max(array) - min(array).
 *
 * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1]
 * Input 2:
 *
 *  A = [4, 7, 3, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  26
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only 1 subarray exists. Its value is 0.
 * Explanation 2:
 *
 * value ( [4] ) = 4 - 4 = 0
 * value ( [7] ) = 7 - 7 = 0
 * value ( [3] ) = 3 - 3 = 0
 * value ( [8] ) = 8 - 8 = 0
 * value ( [4, 7] ) = 7 - 4 = 3
 * value ( [7, 3] ) = 7 - 3 = 4
 * value ( [3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3] ) = 7 - 3 = 4
 * value ( [7, 3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3, 8] ) = 8 - 3 = 5
 * sum of values % 10^9+7 = 26
 */
public class MaxMin {
    public int solve(ArrayList<Integer> A) {
        //4 Arrays
        //ls - left smallest
        //rs - right smallest
        //lg - left greatest
        //rg - right greatest

        ArrayList<Integer> ls = leftSmallest(A);
        ArrayList<Integer> rs = rightSmallest(A);
        ArrayList<Integer> lg = leftGreatest(A);
        ArrayList<Integer> rg = rightGreatest(A);
        long maxSum = 0;
        long minSum = 0;
        int n = A.size();
        int mod = 1000000007;
        //check if A(i) is max in how many subArrays
        for(int i=0;i<n;i++){
            //find the greatest in left and right
            long maxProd = (1L * (i - lg.get(i)) * (rg.get(n-i-1) - i))%mod;
            maxProd = (maxProd * A.get(i))%mod;
            maxSum = (maxSum%mod + maxProd%mod)%mod;

            long minProd = (1L * (i - ls.get(i)) * (rs.get(n-i-1) - i))%mod;
            minProd = (minProd * A.get(i))%mod;
            minSum = (minSum%mod + minProd%mod)%mod;

        }

        return (int)(maxSum - minSum + mod)%mod;

    }

    public ArrayList<Integer> leftSmallest(ArrayList<Integer> A){
        ArrayList<Integer> leftSmallIndex = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n= A.size();
        for(int i=0;i<n;i++){
            while(!stack.empty() && A.get(i)<=A.get(stack.peek())){
                stack.pop();
            }
            if(stack.empty()){
                leftSmallIndex.add(-1);
                stack.push(i);
            }else{
                leftSmallIndex.add(stack.peek());
                stack.push(i);
            }
        }
        return leftSmallIndex;
    }

    public ArrayList<Integer> leftGreatest(ArrayList<Integer> A){
        ArrayList<Integer> leftGreatestIndex = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n= A.size();
        for(int i=0;i<n;i++){
            while(!stack.empty() && A.get(i)>=A.get(stack.peek())){
                stack.pop();
            }
            if(stack.empty()){
                leftGreatestIndex.add(-1);
                stack.push(i);
            }else{
                leftGreatestIndex.add(stack.peek());
                stack.push(i);
            }
        }
        return leftGreatestIndex;
    }

    public ArrayList<Integer> rightSmallest(ArrayList<Integer> A){
        ArrayList<Integer> rightSmallIndex = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n= A.size();
        for(int i=n-1;i>=0;i--){
            while(!stack.empty() && A.get(i)<=A.get(stack.peek())){
                stack.pop();
            }
            if(stack.empty()){
                rightSmallIndex.add(n);
                stack.push(i);
            }else{
                rightSmallIndex.add(stack.peek());
                stack.push(i);
            }
        }
        return rightSmallIndex;
    }

    public ArrayList<Integer> rightGreatest(ArrayList<Integer> A){
        ArrayList<Integer> rightGreatestIndex = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n= A.size();
        for(int i=n-1;i>=0;i--){
            while(!stack.empty() && A.get(i)>=A.get(stack.peek())){
                stack.pop();
            }
            if(stack.empty()){
                rightGreatestIndex.add(n);
                stack.push(i);
            }else{
                rightGreatestIndex.add(stack.peek());
                stack.push(i);
            }
        }
        return rightGreatestIndex;
    }
}
