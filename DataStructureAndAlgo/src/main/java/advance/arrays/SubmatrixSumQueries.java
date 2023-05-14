package advance.arrays;

import java.util.ArrayList;

/**
 *
 * Sub-matrix Sum Queries
 *
 * Problem Description
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
 *
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 *
 * NOTE:
 *
 * Rows are numbered from top to bottom, and columns are numbered from left to right.
 * Sum may be large, so return the answer mod 109 + 7.
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * 1 <= Q <= 100000
 * 1 <= B[i] <= D[i] <= N
 * 1 <= C[i] <= E[i] <= M
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer array B.
 * The third argument given is the integer array C.
 * The fourth argument given is the integer array D.
 * The fifth argument given is the integer array E.
 * (B[i], C[i]) represents the top left corner of the i'th query.
 * (D[i], E[i]) represents the bottom right corner of the i'th query.
 *
 *
 *
 * Output Format
 * Return an integer array containing the submatrix sum for each query.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [   [1, 2, 3]
 *          [4, 5, 6]
 *          [7, 8, 9]   ]
 *  B = [1, 2]
 *  C = [1, 2]
 *  D = [2, 3]
 *  E = [2, 3]
 * Input 2:
 *
 *  A = [   [5, 17, 100, 11]
 *          [0, 0,  2,   8]    ]
 *  B = [1, 1]
 *  C = [1, 4]
 *  D = [2, 2]
 *  E = [2, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [12, 28]
 * Output 2:
 *
 *  [22, 19]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 *  For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
 * Explanation 2:
 *
 *  For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 *  For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 */
public class SubmatrixSumQueries {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        //Find prefix sum row wise
        int row = A.size();
        int col = A.get(0).size();
        int q = B.size();
        ArrayList<Integer> result = new ArrayList<>();
        int mod = 1000000007;
        ArrayList<ArrayList<Long>> prefixSum  = new ArrayList<>();
        for(int i=0;i<row;i++){
            ArrayList<Long> tempList = new ArrayList<>();
            tempList.add((long)A.get(i).get(0));
            prefixSum.add(tempList);
        }

        for(int i=0;i<row;i++){
            for(int j=1;j<col;j++){
                long prev = prefixSum.get(i).get(j-1);
                long ps = (prev % mod + A.get(i).get(j) % mod + mod)%mod;
                prefixSum.get(i).add(ps);
            }
        }

        //ps column wise
        for(int j=0;j<col;j++){
            for(int i=1;i<row;i++){
                long prev = prefixSum.get(i-1).get(j);
                long ps = (prev % mod + prefixSum.get(i).get(j) % mod + mod) % mod ;
                prefixSum.get(i).set(j,ps);
            }
        }

        for(int i=0;i<q;i++){

            int b = B.get(i)-1;
            int c = C.get(i)-1;
            int d = D.get(i)-1;
            int e = E.get(i)-1;

            long ps = (prefixSum.get(d).get(e));

            if(b>0) {
                ps = (ps % mod - prefixSum.get(b-1).get(e) % mod + mod) % mod;
            }if(c>0){
                ps = (ps % mod - prefixSum.get(d).get(c-1) % mod + mod) % mod;
            }if(b>0 && c>0){
                ps = (ps % mod + prefixSum.get(b-1).get(c-1) % mod + mod) % mod;
            }

            result.add((int)((ps + mod)%mod));
        }
        return result;
    }
}
