package advance.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 * Example 1:
 *
 *
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * All the pairs (ai, bi) are distinct.
 * The given input is guaranteed to be a tree and there will be no repeated edges.
 *
 * For Detail Explanation please refer : https://leetcode.com/problems/minimum-height-trees/solutions/900035/minimum-height-trees/
 */
public class MinHeightTree {
    //Both the approaches are same - but instead of arrayList Leet code has taken HashSet - which would be faster to retrieve and remove elements.
    public List<Integer> findMinHeightTreesMyApproach(int n, int[][] edges) {

        if(n<=2){
            ArrayList<Integer> minHeightTrees = new ArrayList<>();
            for(int i=0;i<n;i++){
                minHeightTrees.add(i);
            }

            return minHeightTrees;
        }

        //create an adjacency List
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){

            int from = edges[i][0];
            int to = edges[i][1];
            adjList[from].add(to);
            adjList[to].add(from);

        }

        ArrayList<Integer> leaves = new ArrayList<>();

        for(int i=0;i<n;i++){
            //insert only the leaf nodes
            if(adjList[i].size() == 1){
                leaves.add(i);
            }
        }

        int remainingLeaves = n;

        while(remainingLeaves > 2){

            remainingLeaves = remainingLeaves - leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for(int i=0;i<leaves.size();i++){
                int currNode = leaves.get(i);
                int neighbour = adjList[currNode].iterator().next();
                adjList[neighbour].remove(Integer.valueOf(currNode));
                if(adjList[neighbour].size() == 1){
                    newLeaves.add(neighbour);
                }
            }

            leaves = newLeaves;

        }

        return leaves;

    }
    public List<Integer> findMinHeightTreesLeetCode(int n, int[][] edges) {

        // edge cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        // Build the graph with the adjacency list
        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            neighbors.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        // Initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);

        // Trim the leaves until reaching the centroids
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // remove the current leaves along with the edges
            for (Integer leaf : leaves) {
                // the only neighbor left for the leaf node
                Integer neighbor = neighbors.get(leaf).iterator().next();
                // remove the edge along with the leaf node
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            // prepare for the next round
            leaves = newLeaves;
        }

        // The remaining nodes are the centroids of the graph
        return leaves;
    }
}
