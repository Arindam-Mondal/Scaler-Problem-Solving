package advance.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * */

/**
 * Next Pointer Binary Tree
 *
 * Problem Description
 * Given a binary tree,
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Assume perfect binary tree and try to solve this in constant extra space.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 10^9
 *
 *
 *
 * Input Format
 * First and only argument is head of the binary tree A.
 *
 *
 *
 * Output Format
 * Return the head of the binary tree after the changes are made.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *      1
 *     /  \
 *    2    3
 * Input 2:
 *
 *
 *         1
 *        /  \
 *       2    5
 *      / \  / \
 *     3  4  6  7
 *
 *
 * Example Output
 * Output 1:
 *
 *
 *         1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 * Output 2:
 *
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 5 -> NULL
 *      / \  / \
 *     3->4->6->7 -> NULL
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Next pointers are set as given in the output.
 * Explanation 2:
 *
 * Next pointers are set as given in the output.
 *
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class NextPointerBinaryTree {
    public void connectWithExtraSpace(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty() && queue.peek() != null ){
            while(!queue.isEmpty() && queue.peek() != null){
                TreeLinkNode node = queue.poll();
                node.next = queue.peek();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            queue.remove();
            queue.add(null);
        }
    }

    public void connectWithoutExtraSpace(TreeLinkNode root) {

        TreeLinkNode curr = root; // this pointer is used to traverse horizontally
        TreeLinkNode leftmost = root; // this pointer is used to traverse vertically

        while(curr.left != null){
            curr.left.next = curr.right;
            if(curr.next != null){
                curr.right.next = curr.next.left;
                curr = curr.next;
            }else{
                curr = leftmost.left;
                leftmost = curr;
            }
        }

    }
}
