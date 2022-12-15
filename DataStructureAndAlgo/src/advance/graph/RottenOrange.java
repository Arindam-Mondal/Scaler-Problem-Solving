package advance.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Rotten Oranges
 *
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 *
 * Each cell can have three values:
 *
 * The value 0 representing an empty cell.
 *
 * The value 1 representing a fresh orange.
 *
 * The value 2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
 *
 * Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 *
 * 0 <= A[i][j] <= 2
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 *
 * If this is impossible, return -1 instead.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [2, 1, 1]
 *         [1, 1, 0]
 *         [0, 1, 1]   ]
 * Input 2:
 *
 *
 * A = [   [2, 1, 1]
 *         [0, 1, 1]
 *         [1, 0, 1]   ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
 * Explanation 2:
 *
 *  Task is impossible
 */
public class RottenOrange {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int count = 0;
        Queue<ArrayList<Integer>> bfs = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.get(i).get(j) == 2){
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    bfs.add(index);
                }
            }
        }

        while(!bfs.isEmpty()){
            int size = bfs.size();
            boolean canRot = false;
            for(int k=0;k<size;k++){
                ArrayList<Integer> index = bfs.poll();
                int i = index.get(0);
                int j = index.get(1);

                boolean left = updateCell(A,bfs,i,j+1);
                boolean right = updateCell(A,bfs,i,j-1);
                boolean top = updateCell(A,bfs,i+1,j);
                boolean down = updateCell(A,bfs,i-1,j);

                canRot = canRot || (left || right || top || down);

            }

            count =  canRot ? count+1 : count;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.get(i).get(j) == 1){
                    return -1;
                }
            }
        }

        return count;
    }

    public boolean updateCell(ArrayList<ArrayList<Integer>> A, Queue<ArrayList<Integer>> bfs,int i, int j){
        if(i<0 || j<0 || i>=A.size() || j>=A.get(0).size()){
            return false;
        }
        if(A.get(i).get(j) == 1){
            A.get(i).set(j,2);
            ArrayList<Integer> index = new ArrayList<>();
            index.add(i);
            index.add(j);
            bfs.add(index);
            return true;
        }
        return false;
    }
}
