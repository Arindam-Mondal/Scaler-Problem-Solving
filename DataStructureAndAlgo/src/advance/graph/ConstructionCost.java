package advance.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Construction Cost
 *
 * Problem Description
 * Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
 *
 * Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
 *
 * NOTE: Return the answer modulo 109+7 as the answer can be large.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 * 0 <= C <= 100000
 * 1 <= B[i][0], B[i][1] <= N
 * 1 <= B[i][2] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum construction cost.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * B = [   [1, 2, 14]
 *         [2, 3, 7]
 *         [3, 1, 2]   ]
 * Input 2:
 *
 * A = 3
 * B = [   [1, 2, 20]
 *         [2, 3, 17]  ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 9
 * Output 2:
 *
 * 37
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph.
 * we can reach the 1st node from 2nd and 3rd node using only these two edges.
 * So, the total cost of costruction is 9.
 * Explanation 2:
 *
 * We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
 */
class Construction implements Comparable<Construction> {
    int value;
    int cost;

    Construction(int value,int cost){
        this.value = value;
        this.cost = cost;
    }

    public int compareTo(Construction construction){
        return this.cost - construction.cost;
    }
}

public class ConstructionCost {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        //Using minimal Spanning Tree
        //create the adj List
        ArrayList<Construction>[] adjList = new ArrayList[A+1];
        for(int i=0;i<adjList.length;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<B.size();i++){

            int from = B.get(i).get(0);
            int to = B.get(i).get(1);
            int cost = B.get(i).get(2);

            Construction fromTo = new Construction(to,cost);
            Construction toFrom = new Construction(from,cost);

            adjList[to].add(toFrom);
            adjList[from].add(fromTo);
        }

        int[] cost = new int[A+1];
        int[] parent = new int[A+1];
        boolean[] visited = new boolean[A+1];

        Arrays.fill(cost,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);
        PriorityQueue<Construction> pq = new PriorityQueue<>();

        //Source Node is 1 here and we need to find the min cost which is reachable from 1
        Construction source = new Construction(1,0);
        parent[1] = -1;
        cost[1] = 0;

        pq.add(source);

        while(!pq.isEmpty()){
            Construction currNode = pq.poll();
            int currValue = currNode.value;
            visited[currValue] = true;
            //Visit all the adj Nodes
            for(Construction construction: adjList[currValue]){
                if(visited[construction.value] == false && construction.cost < cost[construction.value]){
                    parent[construction.value] = currValue;
                    cost[construction.value] = construction.cost;
                    pq.add(new Construction(construction.value,construction.cost));
                }
            }
        }

        int mod = 1000000007;
        int minCost = 0;

        for(int i=1;i<cost.length;i++){
            minCost = (minCost%mod + cost[i]%mod)%mod;
        }

        return minCost;
    }
}
