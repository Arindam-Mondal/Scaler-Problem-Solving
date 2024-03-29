package intermediate.tree;

/**
 *  Invert the Binary Tree
 *
 *  Problem Description
 * Given a binary intermediate.tree A, invert the binary intermediate.tree and return it.
 *
 * Inverting refers to making the left child the right child and vice versa.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of intermediate.tree <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the head of the intermediate.tree A.
 *
 *
 *
 * Output Format
 * Return the head of the inverted intermediate.tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *      1
 *    /   \
 *   2     3
 * Input 2:
 *
 *
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 *
 *
 * Example Output
 * Output 1:
 *
 *
 *      1
 *    /   \
 *   3     2
 * Output 2:
 *
 *
 *      1
 *    /   \
 *   3     2
 *  / \   / \
 * 7   6 5   4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Tree has been inverted.
 * Explanation 2:
 *
 * Tree has been inverted.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        invert(A);
        return A;
    }

    public void invert(TreeNode A){
        if(A==null){
            return;
        }
        invert(A.left);
        invert(A.right);
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
    }
}
