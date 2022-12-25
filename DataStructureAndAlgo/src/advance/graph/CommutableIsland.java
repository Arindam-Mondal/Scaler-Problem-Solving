package advance.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

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
