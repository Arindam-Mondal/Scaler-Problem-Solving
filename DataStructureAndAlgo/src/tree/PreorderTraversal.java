package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Preorder Traversal
 *
 * Problem Description
 * Given a binary tree, return the preorder traversal of its nodes values.
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
 * Return an integer array denoting the preorder traversal of the given binary tree.
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
 *  [1, 2, 3]
 * Output 2:
 *
 *  [1, 6, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Preoder Traversal of the given tree is [1, 2, 3].
 * Explanation 2:
 *
 *  The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> R = new ArrayList<>();
        preOrderWithoutRec(A,R);
        return R;
    }

    public void preOrderWithoutRec(TreeNode A, ArrayList<Integer> R){

        TreeNode curr = A;
        Stack<TreeNode> stack = new Stack<>();

        // while(curr != null || stack.size() > 0){
        //     R.add(curr.val);
        //     if(curr.right != null){
        //         stack.push(curr.right);
        //     }
        //     curr = curr.left;
        //     if(curr == null && stack.size() > 0){
        //         curr = stack.pop();
        //     }
        // }

        if(curr == null){
            return;
        }

        stack.push(curr);


        while(curr != null && stack.size() > 0){
            curr = stack.pop();
            R.add(curr.val);
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }

    }
}
