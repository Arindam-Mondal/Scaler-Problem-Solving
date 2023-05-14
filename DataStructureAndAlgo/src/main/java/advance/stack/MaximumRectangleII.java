package advance.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * Maximum Rectangle
 *
 * Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
 *
 * Find the largest rectangle containing only 1's and return its area.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 * Input Format
 *
 * The only argument given is the integer matrix A.
 * Output Format
 *
 * Return the area of the largest rectangle containing only 1's.
 * Constraints
 *
 * 1 <= N, M <= 1000
 * 0 <= A[i] <= 1
 * For Example
 *
 * Input 1:
 *     A = [   [0, 0, 1]
 *             [0, 1, 1]
 *             [1, 1, 1]   ]
 * Output 1:
 *     4
 *
 * Input 2:
 *     A = [   [0, 1, 0, 1]
 *             [1, 0, 1, 0]    ]
 * Output 2:
 *     1
 */
public class MaximumRectangleII {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        //This problem is similar to the maximum area histogram problem.
        //first calculate the height in each row consifdering the above row.
        int n = A.size();
        //considering each row will have the equal length
        int m = A.get(0).size();
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int curr = A.get(i).get(j);
                if( curr != 0){
                    int prev = A.get(i-1).get(j);
                    A.get(i).set(j,curr+prev);
                }
            }
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int area = largestRectangleArea(A.get(i));
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

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
