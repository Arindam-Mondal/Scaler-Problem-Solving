package advance.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description
 * Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
 *
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * First argument is the head of the tree A.
 *
 * Second argument is the integer B.
 *
 *
 *
 * Output Format
 * Return 1 if such a pair can be found, 0 otherwise.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *          10
 *          / \
 *         9   20
 *
 * B = 19
 * Input 2:
 *
 *
 *           10
 *          / \
 *         9   20
 *
 * B = 40
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
 *  10 + 9 = 19. Hence 1 is returned.
 * Explanation 2:
 *
 *  No such pair exists.
 */
public class TwoSumBST {
    Boolean found;
    Set<Integer> elements;
    public int t2Sum(TreeNode A, int B) {
        found = false;
        elements = new HashSet<>();
        traverse(A,B);
        return found? 1:0;
    }

    public void traverse(TreeNode A, int B){
        if(A==null){
            return;
        }
        int x = B - A.val;
        if(elements.contains(x)){
            found = true;
            return;
        }else{
            elements.add(A.val);
        }
        traverse(A.left,B);
        traverse(A.right,B);
    }
}
