package advance.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.
 *
 * Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.
 *
 * Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
 *
 * NOTE: All cities can be visited from any city.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 * 1 <= B[i][0], B[i][1] <= N
 *
 *
 *
 * Input Format
 * First argument is an integer A denoting the number of cities, N.
 *
 * Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of roads king can construct.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = [
 *        [1, 2]
 *        [1, 3]
 *      ]
 * Input 2:
 *
 *  A = 5
 *  B = [
 *        [1, 3]
 *        [1, 4]
 *        [3, 2]
 *        [3, 5]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can't construct any new roads such that the country remains bipartite.
 * Explanation 2:
 *
 *  We can add two roads between cities (4, 2) and (4, 5).
 *
 */
public class ConstructRoads {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        long red = 0;
        long blue = 0;
        int n = B.size();
        int[] colors = new int[A + 1];
        Arrays.fill(colors, -1);
        //create the adjacencyList
        ArrayList<Integer>[] adjacencyList = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        // Arrays.fill(adjacencyList,new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int from = B.get(i).get(0);
            int to = B.get(i).get(1);

            adjacencyList[from].add(to);
            adjacencyList[to].add(from);
        }

        // for(int i=0;i<=A;i++){
        //     System.out.println(adjacencyList[i]);
        // }

        //Start BFS
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == -1) {
                //only then color it.
                colors[i] = 1;
                bfs.add(i);
                while (!bfs.isEmpty()) {
                    int curr = bfs.poll();
                    for (int k : adjacencyList[curr]) {
                        if (colors[k] == -1) {
                            colors[k] = 1 - colors[curr];
                            bfs.add(k);
                        }
                    }
                }
            }
            // System.out.print(colors[i]+" ");
        }
        long mod = 1000000007;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == 1) {
                blue++;
            } else {
                red++;
            }
        }

        return (int) ((blue * red) % mod - n);
    }
}
