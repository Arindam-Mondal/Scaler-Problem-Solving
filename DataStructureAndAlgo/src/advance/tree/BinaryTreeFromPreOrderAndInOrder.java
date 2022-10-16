package advance.tree;

import java.util.ArrayList;

/**
 * Binary Tree From Inorder And Preorder
 * ---------------------------------------
 *
 * Problem Description
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * NOTE: You may assume that duplicates do not exist in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First argument is an integer array A denoting the preorder traversal of the tree.
 *
 * Second argument is an integer array B denoting the inorder traversal of the tree.
 *
 *
 *
 * Output Format
 * Return the root node of the binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 *  B = [2, 1, 3]
 * Input 2:
 *
 *  A = [1, 6, 2, 3]
 *  B = [6, 1, 3, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *    1
 *   / \
 *  2   3
 * Output 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Create the binary tree and return the root node of the tree.
 */
public class BinaryTreeFromPreOrderAndInOrder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        if(A.size() == 0 || B.size() == 0){
            return null;
        }
        TreeNode root = new TreeNode(A.get(0));
        ArrayList<ArrayList<Integer>> preInorderList = split(A,B,root.val);
        ArrayList<Integer> la = preInorderList.get(0);
        ArrayList<Integer> ra = preInorderList.get(1);
        ArrayList<Integer> lb = preInorderList.get(2);
        ArrayList<Integer> rb = preInorderList.get(3);

        root.left = buildTree(la,lb);
        root.right = buildTree(ra,rb);
        return root;

    }

    public ArrayList<ArrayList<Integer>> split(ArrayList<Integer> A,ArrayList<Integer> B, int n){
        int pos = -1;
        for(int i=0;i<B.size();i++){
            int num = B.get(i);
            if(num == n){
                pos = i;
                break;
            }
        }

        ArrayList<Integer> la = new ArrayList<>();
        ArrayList<Integer> ra = new ArrayList<>();
        ArrayList<Integer> lb = new ArrayList<>();
        ArrayList<Integer> rb = new ArrayList<>();

        for(int i=1;i<=pos;i++){
            la.add(A.get(i));
            lb.add(B.get(i-1));
        }
        for(int i=pos+1;i<A.size();i++){
            ra.add(A.get(i));
            rb.add(B.get(i));
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(la);
        result.add(ra);
        result.add(lb);
        result.add(rb);

        return result;
    }
}
