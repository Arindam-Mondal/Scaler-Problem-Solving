package advance.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Nearest Exit from Entrance in Maze
 *
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 *
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 *
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 *
 * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * Output: 1
 * Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
 * Initially, you are at the entrance cell [1,2].
 * - You can reach [1,0] by moving 2 steps left.
 * - You can reach [0,2] by moving 1 step up.
 * It is impossible to reach [2,3] from the entrance.
 * Thus, the nearest exit is [0,2], which is 1 step away.
 *
 *
 * Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * Output: 2
 * Explanation: There is 1 exit in this maze at [1,2].
 * [1,0] does not count as an exit since it is the entrance cell.
 * Initially, you are at the entrance cell [1,0].
 * - You can reach [1,2] by moving 2 steps right.
 * Thus, the nearest exit is [1,2], which is 2 steps away.
 * Example 3:
 *
 *
 * Input: maze = [[".","+"]], entrance = [0,0]
 * Output: -1
 * Explanation: There are no exits in this maze.
 *
 * Constraints:
 *
 * maze.length == m
 * maze[i].length == n
 * 1 <= m, n <= 100
 * maze[i][j] is either '.' or '+'.
 * entrance.length == 2
 * 0 <= entrancerow < m
 * 0 <= entrancecol < n
 * entrance will always be an empty cell.
 */
public class NearestExitFromMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        //solv using bfs - as bfs would help us to find the shortest distance
        int row = maze.length;
        int col = maze[0].length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';

        while(!bfs.isEmpty()){
            int[] curr = bfs.poll();

            int currRow = curr[0];
            int currCol = curr[1];
            int currDistance = curr[2];

            for(int[] dir : dirs){
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                if(nextRow >=0 && nextRow < row && nextCol >=0 && nextCol < col && maze[nextRow][nextCol] == '.'){
                    if(nextRow == 0 || nextCol == 0 || nextRow == row-1 || nextCol == col-1){
                        return currDistance+1;
                    }
                    maze[nextRow][nextCol] = '+';
                    bfs.offer(new int[]{nextRow,nextCol,currDistance+1});
                }
            }
        }

        return -1;

    }
}