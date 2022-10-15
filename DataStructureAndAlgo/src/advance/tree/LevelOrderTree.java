package advance.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order
 *
 * Problem Description
 * Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only argument is root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Input 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *    [3],
 *    [9, 20],
 *    [15, 7]
 *  ]
 * Output 2:
 *
 *  [
 *    [1]
 *    [6, 2]
 *    [3]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrderTree {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A);
        queue.add(null);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty() && queue.size() > 1){
            ArrayList<Integer> levelList = new ArrayList<>();
            while(queue.peek()!=null){
                TreeNode tn= queue.poll();
                levelList.add(tn.val);
                if(tn.left != null){
                    queue.add(tn.left);
                }
                if(tn.right != null){
                    queue.add(tn.right);
                }
            }
            queue.poll();
            queue.add(null);
            result.add(levelList);
        }
        return result;
    }
}
