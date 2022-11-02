package advance.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
 *
 * You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
 *
 * NOTE:
 *
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 * -1 <= A[i] <= 105
 *
 *
 *
 * Input Format
 * Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
 *
 *
 *
 * Output Format
 * Return the root node of the Binary Tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Input 2:
 *
 *  A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 *
 *
 * Example Output
 * Output 1:
 *
 *            1
 *          /   \
 *         2     3
 *        / \
 *       4   5
 * Output 2:
 *
 *             1
 *           /   \
 *          2     3
 *         / \ .   \
 *        4   5 .   6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 *  Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 *
 *  Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 *  Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
public class DeserializeBinaryTree {
    public TreeNode solve(ArrayList<Integer> A) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = createNode(A.get(0));
        queue.add(root);
        queue.add(null);
        int i = 1;
        while(!queue.isEmpty() && queue.peek()!=null){
            while(!queue.isEmpty() && queue.peek()!=null){
                TreeNode node = queue.poll();
                TreeNode leftChild = createNode(A.get(i));
                i++;
                TreeNode rightChild = createNode(A.get(i));
                i++;

                if(leftChild != null){
                    node.left = leftChild;
                    queue.add(leftChild);
                }

                if(rightChild != null){
                    node.right = rightChild;
                    queue.add(rightChild);
                }
            }
            queue.remove();
            queue.add(null);
        }

        return root;

    }
    public TreeNode createNode(int val){
        if (val == -1){
            return null;
        }
        TreeNode node = new TreeNode(val);
        return node;
    }
}
