package advance.tree;

/**
 * Sorted Array To Balanced BST
 *
 * Problem Description
 * Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
 *
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of array <= 100000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return a root node of the Binary Search Tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A : [1, 2, 3]
 * Input 2:
 *
 *  A : [1, 2, 3, 5, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *       2
 *     /   \
 *    1     3
 * Output 2:
 *
 *       3
 *     /   \
 *    2     5
 *   /       \
 *  1         10
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  You need to return the root node of the Binary Tree.
 *
 */
public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(final int[] A) {
        return constructBinaryTree(A,0,A.length-1);
    }

    public TreeNode constructBinaryTree(int[] A, int pos1, int pos2){
        if(pos2<pos1){
            return null;
        }
        int midPos = (pos1+pos2)/2;
        TreeNode root = new TreeNode(A[midPos]);
        root.left = constructBinaryTree(A,pos1,midPos-1);
        root.right = constructBinaryTree(A,midPos+1,pos2);

        return root;

    }
}
