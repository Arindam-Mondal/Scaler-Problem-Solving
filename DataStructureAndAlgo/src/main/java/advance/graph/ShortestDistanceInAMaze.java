package advance.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Problem Description
 * Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
 *
 * 1 represents a wall in a matrix and 0 represents an empty location in a wall.
 *
 * There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
 *
 * Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
 *
 * Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 *
 *
 *
 * Problem Constraints
 * 2 <= N, M <= 100
 *
 * 0 <= A[i] <= 1
 *
 * 0 <= B[i][0], C[i][0] < N
 *
 * 0 <= B[i][1], C[i][1] < M
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 * The second argument given is an array of integer B.
 *
 * The third argument if an array of integer C.
 *
 *
 *
 * Output Format
 * Return a single integer, the minimum distance required to reach destination
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [ [0, 0], [0, 0] ]
 * B = [0, 0]
 * C = [0, 1]
 * Input 2:
 *
 * A = [ [0, 0], [0, 1] ]
 * B = [0, 0]
 * C = [0, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Go directly from start to destination in distance 1.
 * Explanation 2:
 *
 *  Go directly from start to destination in distance 1.
 *
 *  Refernce Link :: https://leetcode.com/problems/the-maze-ii/solutions/127457/official-solution/
 *
 */
public class ShortestDistanceInAMaze {
    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        //Use DFS to solve the probvlem
        int[][] dist = new int[A.size()][A.get(0).size()];
        for(int[] rows: dist){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        //initializing the start point with 0
        dist[B.get(0)][B.get(1)] = 0;
        dfs(A,dist,B);
        return dist[C.get(0)][C.get(1)] == Integer.MAX_VALUE ? -1 : dist[C.get(0)][C.get(1)];
    }

    public void dfs(ArrayList<ArrayList<Integer>> A,int[][] dist ,ArrayList<Integer> start){
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : dirs){
            int x = start.get(0) + dir[0];
            int y = start.get(1) + dir[1];
            int count = 0;
            //keep rolling until empty spaces
            while(x>=0 && y>=0 && x<dist.length && y<dist[0].length && A.get(x).get(y) == 0){
                x = x + dir[0];
                y = y + dir[1];
                count++;
            }

            if(dist[start.get(0)][start.get(1)] + count < dist[x-dir[0]][y-dir[1]]){
                dist[x-dir[0]][y-dir[1]] = dist[start.get(0)][start.get(1)] + count;
                ArrayList<Integer> newStart = new ArrayList<>();
                newStart.add(x-dir[0]);
                newStart.add(y-dir[1]);
                dfs(A,dist,newStart);
            }
        }
    }
}
