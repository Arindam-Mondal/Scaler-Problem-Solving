package advance.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Dijsktra
 *
 * Problem Description
 * Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
 *
 * You have to find an integer array D of size A such that:
 *
 * => D[i] : Shortest distance form the C node to node i.
 *
 * => If node i is not reachable from C then -1.
 *
 * Note:
 *
 * There are no self-loops in the graph.
 *
 * No multiple edges between two pair of vertices.
 *
 * The graph may or may not be connected.
 *
 * Nodes are numbered from 0 to A-1.
 *
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1e5
 *
 * 0 <= B[i][0],B[i][1] < A
 *
 * 0 <= B[i][2] <= 1e3
 *
 * 0 <= C < A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A, representing the number of nodes.
 *
 * The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].
 *
 * The third argument given is an integer C.
 *
 *
 *
 * Output Format
 * Return the integer array D.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 6
 * B = [   [0, 4, 9]
 *         [3, 4, 6]
 *         [1, 2, 1]
 *         [2, 5, 1]
 *         [2, 4, 5]
 *         [0, 3, 7]
 *         [0, 1, 1]
 *         [4, 5, 7]
 *         [0, 5, 1] ]
 * C = 4
 * Input 2:
 *
 * A = 5
 * B = [   [0, 3, 4]
 *         [2, 3, 3]
 *         [0, 1, 9]
 *         [3, 4, 10]
 *         [1, 3, 8]  ]
 * C = 4
 *
 *
 * Example Output
 * Output 1:
 *
 * D = [7, 6, 5, 6, 0, 6]
 * Output 2:
 *
 * D = [14, 18, 13, 10, 0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All Paths can be considered from the node C to get shortest path
 * Explanation 2:
 *
 *  All Paths can be considered from the node C to get shortest path
 */
class DijsktraPair implements Comparable<DijsktraPair>{
    int val;
    int weight;
    DijsktraPair(int val, int weight){
        this.val = val;
        this.weight = weight;
    }

    public int compareTo(DijsktraPair p){
        return this.weight - p.weight;
    }
}
public class Dijsktra {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        //create the adj list of Pairs
        ArrayList<DijsktraPair>[] adjList = new ArrayList[A];

        for(int i=0;i<A;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<B.size();i++){
            int from = B.get(i).get(0);
            int to = B.get(i).get(1);
            int weight = B.get(i).get(2);
            DijsktraPair fromTo = new DijsktraPair(to,weight);
            DijsktraPair toFrom = new DijsktraPair(from,weight);

            adjList[from].add(fromTo);
            adjList[to].add(toFrom);
        }

        //Array to store the distance
        int[] distance = new int[A];

        Arrays.fill(distance,-1);

        //Visist the nodes and find min distance
        //source is C
        PriorityQueue<DijsktraPair> pq = new PriorityQueue<>();
        DijsktraPair sourcePair = new DijsktraPair(C,0);
        pq.add(sourcePair);
        distance[C] = 0;

        while(!pq.isEmpty()){
            DijsktraPair currPair = pq.poll();
            int currSource = currPair.val;
            int currWeight = currPair.weight;

            //find all the connecting nodes from source
            for(DijsktraPair next:adjList[currSource]){
                int nextNode = next.val;
                int nextWeight = next.weight;
                //check if the distance from source to next node distance is less than what we have in distance Array
                int totDistatanceFromSource = currWeight + nextWeight;
                if(distance[nextNode] == -1 || totDistatanceFromSource<=distance[nextNode]){
                    distance[nextNode] = totDistatanceFromSource;
                    //create a pair and store in PriorityQueue
                    DijsktraPair pair = new DijsktraPair(nextNode,totDistatanceFromSource);
                    pq.add(pair);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<distance.length;i++){
            result.add(distance[i]);
        }

        return result;

    }
}
