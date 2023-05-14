package advance.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 *
 * Problem Description
 * Given an array of integers A.
 *
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 *
 * Find the area of the largest rectangle formed by the histogram.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000000
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 *
 *  A = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * Explanation 2:
 *
 * Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(ArrayList<Integer> A) {
        //find left smallest Index
        ArrayList<Integer> leftSmallestIndex = new ArrayList<>();
        Stack<Integer> leftStack = new Stack<>();
        int n= A.size();
        for(int i=0;i<n;i++){
            while(!leftStack.empty() && A.get(i) <= A.get(leftStack.peek())){
                leftStack.pop();
            }
            if(leftStack.empty()){
                leftSmallestIndex.add(-1);
                leftStack.push(i);
            }else{
                leftSmallestIndex.add(leftStack.peek());
                leftStack.push(i);
            }
            // System.out.println(leftStack);
        }
        //find the right snmallest Index
        ArrayList<Integer> rightSmallestIndex = new ArrayList<>();
        Stack<Integer> rightStack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!rightStack.empty()&& A.get(i)<=A.get(rightStack.peek())){
                rightStack.pop();
            }
            if(rightStack.empty()){
                rightSmallestIndex.add(n);
                rightStack.push(i);
            }else{
                rightSmallestIndex.add(rightStack.peek());
                rightStack.push(i);
            }
        }
        // System.out.println(leftSmallestIndex);
        // System.out.println(rightSmallestIndex);
        //find the largest length using the right and the left stack
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            int area = A.get(i) * (rightSmallestIndex.get(n-i-1) - leftSmallestIndex.get(i) -1);
            // System.out.println(area);
            ans = Math.max(ans,area);
        }
        return ans;
    }
}
