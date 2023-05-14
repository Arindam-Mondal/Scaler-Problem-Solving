package advance.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Distance of nearest cell
 *
 *  Problem Description
 * Given a matrix of integers A of size N x M consisting of 0 or 1.
 *
 * For each cell of the matrix find the distance of nearest 1 in the matrix.
 *
 * Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
 *
 * Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.
 *
 * NOTE: There is atleast one 1 is present in the matrix.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 *
 * 0 <= A[i][j] <= 1
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the matrix B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [0, 0, 0, 1]
 *        [0, 0, 1, 1]
 *        [0, 1, 1, 0]
 *      ]
 * Input 2:
 *
 *  A = [
 *        [1, 0, 0]
 *        [0, 0, 0]
 *        [0, 0, 0]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *    [3, 2, 1, 0]
 *    [2, 1, 0, 0]
 *    [1, 0, 0, 1]
 *  ]
 * Output 2:
 *
 *  [
 *    [0, 1, 2]
 *    [1, 2, 3]
 *    [2, 3, 4]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 *  A[1][0], A[1][1] will be nearest to A[1][2].
 *  A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
 * Explanation 2:
 *
 *  There is only a single 1. Fill the distance from that 1.
 */

class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}

public class DistanceBetweenNearestCell {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=0;i<A.size();i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<A.get(i).size();j++){
                row.add(-1);
            }
            result.add(row);
        }

        Queue<Pair> bfs = new LinkedList<>();

        for(int i=0;i<result.size();i++){
            for(int j=0;j<result.get(i).size();j++){
                if(A.get(i).get(j) == 1){
                    bfs.add(new Pair(i,j));
                    result.get(i).set(j,0);
                }
            }
        }

        while(!bfs.isEmpty()){
            Pair pair = bfs.poll();
            int i = pair.i;
            int j = pair.j;
            int currVal = result.get(i).get(j);
            //top
            validateAndInsert(result,bfs,i-1,j,currVal);
            //down
            validateAndInsert(result,bfs,i+1,j,currVal);
            //left
            validateAndInsert(result,bfs,i,j-1,currVal);
            //right
            validateAndInsert(result,bfs,i,j+1,currVal);
        }

        return result;

    }

    public void validateAndInsert(ArrayList<ArrayList<Integer>> result,Queue<Pair> bfs,int i, int j,int currVal){
        if(i<0 || j<0 || i>= result.size() || j>= result.get(0).size()){
            return;
        }
        if(result.get(i).get(j) == -1){
            bfs.add(new Pair(i,j));
            result.get(i).set(j,currVal+1);
        }
    }

}
