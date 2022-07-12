package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * NOTE: Using recursion is not allowed.
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
 * Return an integer array denoting the inorder traversal of the given binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *    1
 *     \
 *      2
 *     /
 *    3
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
 *  [1, 3, 2]
 * Output 2:
 *
 *  [6, 1, 3, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Inorder Traversal of the given tree is [1, 3, 2].
 * Explanation 2:
 *
 *  The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> R = new ArrayList<>();
        // inOrder(A,R);
        inOrderWithoutRec(A,R);
        return R;
    }

    public void inOrder(TreeNode A, ArrayList<Integer> R){
        if(A == null){
            return;
        }
        inOrder(A.left,R);
        R.add(A.val);
        inOrder(A.right,R);
    }

    public void inOrderWithoutRec(TreeNode A, ArrayList<Integer> R){

        TreeNode curr = A;

        Stack<TreeNode> stack = new Stack<>();

        while(curr != null || stack.size() > 0){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            R.add(curr.val);
            curr = curr.right;
        }

    }
}
