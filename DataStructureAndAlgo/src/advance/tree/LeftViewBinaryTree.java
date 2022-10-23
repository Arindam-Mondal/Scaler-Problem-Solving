package advance.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Left View of Binary tree
 *
 * Problem Description
 * Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
 *
 * Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
 *
 * NOTE: The value comes first in the array which have lower level.
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
 * First and only argument is a root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the left view of the Binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *             1
 *           /   \
 *          2    3
 *         / \  / \
 *        4   5 6  7
 *       /
 *      8
 * Input 2:
 *
 *             1
 *            /  \
 *           2    3
 *            \
 *             4
 *              \
 *               5
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 4, 8]
 * Output 2:
 *
 *  [1, 2, 4, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Left view of the binary tree is returned.
 */
public class LeftViewBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty() && queue.peek() != null){
            boolean visited = true;
            while(queue.peek()!=null){
                TreeNode n = queue.poll();
                if(visited){
                    result.add(n.val);
                    visited = false;
                }
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
            queue.remove();
            queue.add(null);
        }
        return result;
    }
}
