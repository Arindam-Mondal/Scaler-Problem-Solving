package advance.graph;

import java.util.ArrayList;

/**
 *
 * Floyd Warshall Algorithm
 *
 * Problem Description
 * Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
 *
 * If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
 *
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
 *
 * If there is no possible path from vertex i to vertex j , B[i][j] = -1
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 200
 * -1 <= A[i][j] <= 1000000
 *
 *
 * Input Format
 * The first and only argument given is the integer matrix A.
 *
 *
 * Output Format
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j
 * If there is no possible path from vertex i to vertex j, B[i][j] = -1.
 *
 *
 * Example Input
 * A = [ [0 , 50 , 39]
 *           [-1 , 0 , 1]
 *           [-1 , 10 , 0] ]
 *
 *
 * Example Output
 * [ [0 , 49 , 39 ]
 *    [-1 , 0 , -1 ]
 *    [-1 , 10 , 0 ] ]
 *
 *
 * Example Explanation
 * Shortest Path from 1 to 2 would be 1 ---> 3 ---> 2 and not directly from 1 to 2,
 * All remaining distances remains same.
 */
public class FloydWarshallAlgorithm {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int max = 1000001;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A.get(i).get(j) == -1){
                    A.get(i).set(j,max);
                }
            }
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int cost = Math.min(A.get(i).get(j),A.get(i).get(via) + A.get(via).get(j));
                    A.get(i).set(j,cost);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A.get(i).get(j) == max){
                    A.get(i).set(j,-1);
                }
            }
        }

        return A;
    }
}
