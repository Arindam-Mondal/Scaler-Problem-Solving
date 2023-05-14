package advance.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Commutable Island
 *
 * Problem Description
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 *
 * We need to find bridges with minimal cost such that all islands are connected.
 *
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, M <= 6*104
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 * 1 <= B[i][2] <= 103
 *
 *
 *
 * Input Format
 * The first argument contains an integer, A, representing the number of islands.
 *
 * The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
 *
 *
 *
 * Output Format
 * Return an integer representing the minimal cost required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 *  B = [  [1, 2, 1]
 *         [2, 3, 4]
 *         [1, 4, 3]
 *         [4, 3, 2]
 *         [1, 3, 10]  ]
 * Input 2:
 *
 *  A = 4
 *  B = [  [1, 2, 1]
 *         [2, 3, 2]
 *         [3, 4, 4]
 *         [1, 4, 3]   ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
 * Explanation 2:
 *
 *  We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 */
class Node implements Comparable<Node>{
    int value;
    int weight;
    Node(int value,int weight){
        this.value = value;
        this.weight = weight;
    }

    public int compareTo(Node node){
        return this.weight-node.weight;
    }
}
public class CommutableIsland {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        ArrayList<Node>[] adjList = new ArrayList[A+1];
        for(int i=1;i<=A;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<B.size();i++){

            int from = B.get(i).get(0);
            int to = B.get(i).get(1);
            int val = B.get(i).get(2);

            Node fromTo = new Node(to,val);
            Node toFrom = new Node(from,val);

            adjList[from].add(fromTo);
            adjList[to].add(toFrom);
        }

        boolean[] visited = new boolean[A+1];
        int[] parent = new int[A+1];
        int[] minWeight = new int[A+1];

        for(int i=1;i<minWeight.length;i++){
            minWeight[i] = Integer.MAX_VALUE;
        }

        //pace the first Node
        PriorityQueue<Node> pq = new PriorityQueue<>();
        parent[1] = -1;
        minWeight[1] = 0;
        Node firstNode = new Node(1,0);
        pq.add(firstNode);

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int currVal = currNode.value;
            //mark the node as visited;
            visited[currVal] = true;
            //traverse the adjacent node of currVal
            for(Node next:adjList[currVal]){
                if(visited[next.value] == false && minWeight[next.value] > next.weight){
                    //set the parent of next as curr node
                    parent[next.value] = currVal;
                    minWeight[next.value] = next.weight;
                    Node nextNode = new Node(next.value,next.weight);
                    pq.add(nextNode);
                }
            }
        }
        int minCost = 0;
        for(int i=1;i<minWeight.length;i++){
            minCost = minCost + minWeight[i];
        }

        return minCost;
    }
}
