package advance.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *Problem Description
 * Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
 *
 * NOTE: Consider the level of root node as 1.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 109
 *
 *
 *
 * Input Format
 * First and only argument is a root node of the binary tree, A
 *
 *
 *
 * Output Format
 * Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 *   /
 *  8
 * Input 2:
 *
 *         1
 *        / \
 *       2   10
 *        \
 *         4
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  -7
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Sum of nodes at odd level = 23
 *  Sum of ndoes at even level = 13
 * Explanation 2:
 *
 *  Sum of nodes at odd level = 5
 *  Sum of ndoes at even level = 12
 */
public class OddAndEvenLevels {
    public int solve(TreeNode A) {
        long evenSum = 0;
        long oddSum = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        int i=1;
        while(!queue.isEmpty() && queue.peek() != null){
            while(!queue.isEmpty() && queue.peek() != null){
                TreeNode node = queue.poll();
                if(i%2 !=0){
                    oddSum = oddSum + node.val;
                }else{
                    evenSum = evenSum + node.val;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            i++;
            queue.remove();
            queue.add(null);
        }

        return (int)(oddSum-evenSum);
    }
}
