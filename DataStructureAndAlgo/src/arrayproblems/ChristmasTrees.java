package arrayproblems;

import java.util.ArrayList;

/**
 * Problem Description
 * You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
 * The cost of these trees is Bp + Bq + Br.
 *
 * You are to choose 3 trees such that their total cost is minimum. Return that cost.
 *
 * If it is not possible to choose 3 such trees return -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= A[i], B[i] <= 109
 * 3 <= size(A) = size(B) <= 3000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 * Second argument is an integer array B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum cost of choosing 3 trees whose heights are strictly in increasing order, if not possible, -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 3, 5]
 *  B = [1, 2, 3]
 * Input 2:
 *
 *  A = [1, 6, 4, 2, 6, 9]
 *  B = [2, 5, 7, 3, 2, 7]
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  7
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6.
 */
public class ChristmasTrees {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<B.size();i++){
            //if B(i) is greater than min then b(i) + b(j) + b(k) will always be greater than min.
            if(B.get(i)>min){
                continue;
            }
            for(int j=i+1;j<B.size();j++){
                //Similarly if b(i) + b(j) is greater than min then no need to proceed as anything
                // added to it would always be greater than min.
                //Also if A(j) < A(i) we need not proceed as, the problem description says A[i]<A[j]<A[k]
                if((B.get(i) + B.get(j)) > min || A.get(j)<=A.get(i)) {
                    continue;
                }
                for(int k= j+1;k<B.size();k++){
                    int sum = B.get(i) + B.get(j) + B.get(k);
                    if(min>sum && A.get(i)<A.get(j) && A.get(j)<A.get(k)){
                        min = sum;
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}
