package intermediate.tree;

import java.util.ArrayList;

/**
 * Counting the Nodes
 *
 * Problem Description
 * Given the root of a intermediate.tree A with each node having a certain value, find the count of nodes with more value than all its ancestor.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of Nodes <= 200000
 *
 * 1 <= Value of Nodes <= 2000000000
 *
 *
 *
 * Input Format
 * The first and only argument of input is a intermediate.tree node.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the count of nodes that have more value than all of its ancestors.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *      3
 * Input 2:
 *
 *
 *     4
 *    / \
 *   5   2
 *      / \
 *     3   6
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There's only one node in the intermediate.tree that is the valid node.
 * Explanation 2:
 *
 *  The valid nodes are 4, 5 and 6.
 */
public class CountingTheNodes {

    public int solve(TreeNode A) {
        ArrayList<Integer> count = new ArrayList<>();
        count.add(1);
        countNodes(A,A.val, count);
        return count.get(0);
    }

    public void countNodes(TreeNode A,int maxValue, ArrayList<Integer> count){
        if(A==null){
            return;
        }
        if(A.val>maxValue){
            count.set(0,count.get(0)+1);
        }
        countNodes(A.left,Math.max(maxValue,A.val),count);
        countNodes(A.right,Math.max(maxValue,A.val),count);
    }
}
