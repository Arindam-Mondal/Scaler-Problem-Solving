package advance.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Equal Tree Partition
 *
 * Problem Description
 * Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 0 <= value of node <= 109
 *
 *
 *
 * Input Format
 * First and only argument is head of tree A.
 *
 *
 *
 * Output Format
 * Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *                 5
 *                /  \
 *               3    7
 *              / \  / \
 *             4  6  5  6
 * Input 2:
 *
 *
 *                 1
 *                / \
 *               2   10
 *                   / \
 *                  20  2
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Remove edge between 5(root node) and 7:
 *         Tree 1 =                                               Tree 2 =
 *                         5                                                     7
 *                        /                                                     / \
 *                       3                                                     5   6
 *                      / \
 *                     4   6
 *         Sum of Tree 1 = Sum of Tree 2 = 18
 * Explanation 2:
 *
 *  The given Tree cannot be partitioned.
 */
public class EqualPartitionTree {
    public int solve(TreeNode A) {
        Map<Long,Integer> countMap = new HashMap<>();
        long tot = partitionSum(A,countMap);
        if(tot == 0){
            return countMap.getOrDefault(tot,0) > 1 ? 1 : 0;
        }

        return (tot%2 == 0 && countMap.getOrDefault(tot/2,0) > 0) ? 1 : 0;

    }

    //Find the sum of each left and right sub tree from the bottom and store it in a map
    //Now to have a equal partition -  there should be a element in the map which has the key as totalSum/2
    //Using the above logic problem is solved recursively.
    public long partitionSum(TreeNode A, Map<Long,Integer> countMap){
        if(A==null){
            return 0;
        }
        long sum = A.val + partitionSum(A.left,countMap) + partitionSum(A.right,countMap);
        countMap.put(sum,countMap.getOrDefault(sum,0)+1);
        return sum;
    }
}
