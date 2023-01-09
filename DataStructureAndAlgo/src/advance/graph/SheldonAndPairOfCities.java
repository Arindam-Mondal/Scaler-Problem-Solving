package advance.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Sheldon and Pair of Cities
 *
 * Problem Description
 * Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.
 *
 * Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the cities and F[i] denotes the distance between the cities.
 *
 * Now he has many lectures to give in the city and is running short of time, so he asked you C queries, for each query i, find the shortest distance between city G[i] and H[i].
 *
 * If the two cities are not connected then the distance between them is assumed to be -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 200
 *
 * 1 <= B <= 200000
 *
 * 1 <= C <= 100000
 *
 * 1 <= F[i] <= 1000000
 *
 * 1 <= D[i], E[i], G[i], H[i] <= A
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Seocnd argument is an integer B.
 * Third argument is an integer C.
 * Fourth argument is an integer array D.
 * Fifth argument is an integer array E.
 * Sixth argument is an integer array F.
 * Seventh argument is an integer array G.
 * Eight argument is an integer array H.
 *
 *
 *
 * Output Format
 * Return an integer array of size C, for each query denoting the shortest distance between the given two vertices.
 * If the two vertices are not connected then output -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 *  B = 6
 *  C = 2
 *  D = [1, 2, 3, 2, 4, 3]
 *  E = [2, 3, 4, 4, 1, 1]
 *  F = [4, 1, 1, 1, 1, 1]
 *  G = [1, 1]
 *  H = [2, 3]
 * Input 2:
 *
 *  A = 3
 *  B = 3
 *  C = 2
 *  D = [1, 2, 1]
 *  E = [2, 3, 3]
 *  F = [3, 1, 1]
 *  G = [2, 1]
 *  H = [3, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 1]
 * Output 2:
 *
 *  [1, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Distance between (1,2) will 2 if we take path 1->4->2.
 *  Distance between (1,3) will 1 if we take path 1->3.
 * Explanation 2:
 *
 *  Distance between (2,3) will 1 if we take path 1->3.
 *  Distance between (1,2) will 2 if we take path 1->3->2.
 */
public class SheldonAndPairOfCities {

    public ArrayList<Integer> solve(int A, int B, int C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F, ArrayList<Integer> G, ArrayList<Integer> H) {
        int[][] distance = new int[A][A];

        for(int[] rows: distance){
            Arrays.fill(rows,1000001);
        }

        for(int i=0;i<A;i++){
            distance[i][i] = 0;
        }

        for(int i=0;i<F.size();i++){
            int from = D.get(i)-1;
            int to = E.get(i)-1;
            int cost = F.get(i);
            distance[from][to] = distance[from][to] < cost ? distance[from][to] : cost;
            distance[to][from] = distance[to][from] < cost ? distance[to][from] : cost;
        }



        for(int via=0;via<A;via++){
            for(int i=0;i<A;i++){
                for(int j=0;j<A;j++){
                    int cost = Math.min(distance[i][j],distance[i][via] + distance[via][j]);
                    distance[i][j] = cost;
                }
            }
        }

        ArrayList<Integer> shortestDist = new ArrayList<>();
        for(int i=0;i<C;i++){
            // System.out.println(distance[G.get(i)-1][H.get(i)-1] + " "+distance[H.get(i)-1][G.get(i)-1]);
            int dist = distance[G.get(i)-1][H.get(i)-1] == 1000001 ? -1 : distance[G.get(i)-1][H.get(i)-1];
            shortestDist.add(dist);
        }

        return shortestDist;
    }
}
