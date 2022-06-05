package ArrayProblems;

import java.util.ArrayList;

/**
 * Problem Description
 * You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).
 *
 * Problem Constraints
 * 1 <= M, N, P <= 100
 *
 * -100 <= A[i][j], B[i][j] <= 100
 *
 *
 *
 * Input Format
 * First argument is a 2D integer matrix A.
 *
 * Second argument is a 2D integer matrix B.
 *
 *
 *
 * Output Format
 * Return a 2D integer matrix denoting AB.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [[1, 2],            B = [[5, 6],
 *       [3, 4]]                 [7, 8]]
 * Input 2:
 *
 *  A = [[1, 1]]            B = [[2],
 *                               [3]]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [[19, 22],
 *   [43, 50]]
 * Output 2:
 *
 *  [[5]]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  image
 * Explanation 2:
 *
 *  [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]
 */
public class MatrixMultiplication {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        int m = B.get(0).size();
        int r = A.get(0).size();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> columnList = new ArrayList<>();
            for(int j=0;j<m;j++){
                int sum = 0;
                for(int k=0;k<r;k++){
                    sum = sum + A.get(i).get(k)*B.get(k).get(j);
                }
                columnList.add(sum);
            }
            resultList.add(columnList);
        }
        return resultList;
    }
}
