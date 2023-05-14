package advance.linkedlist;

/**
 * Flatten a linked list
 *
 * Problem Description
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 *
 * Pointer to next node in the main list (right pointer)
 * Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
 * You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
 *
 *
 *
 * Problem Constraints
 * 1 <= Total nodes in the list <= 100000
 *
 * 1 <= Value of node <= 109
 *
 *
 *
 * Input Format
 * The only argument given is head pointer of the doubly linked list.
 *
 *
 *
 * Output Format
 * Return the head pointer of the Flattened list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *    3 -> 4 -> 20 -> 20 ->30
 *    |    |    |     |    |
 *    7    11   22    20   31
 *    |               |    |
 *    7               28   39
 *    |               |
 *    8               39
 * Input 2:
 *
 *    2 -> 4
 *    |    |
 *    7    11
 *    |
 *    7
 *
 *
 * Example Output
 * Output 1:
 *
 *  3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39
 * Output 2:
 *
 *  2 -> 4 -> 7 -> 7 -> 11
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The return linked list is the flatten sorted list.
 */


class ListNodeX {
    int val;
    ListNodeX right, down;
    ListNodeX(int x) {
        val = x;
        right = down = null;
    }
}

public class FlattenLinkedList {
    ListNodeX flatten(ListNodeX root) {

        ListNodeX curr = root;
        ListNodeX next;
        ListNodeX down = null;
        while(curr != null){
            next = curr.right;
            down = curr.down;
            while(down!=null){
                curr.down = down;
                curr = down;
                down = down.down;
            }
            curr.down = next;
            curr = next;
        }
        return sortList(root);
    }

    public ListNodeX sortList(ListNodeX A) {
        if(A==null || A.down == null){
            return A;
        }
        ListNodeX slow = A;
        ListNodeX fast = A;
        ListNodeX prevSlow = null;
        while(fast != null && fast.down != null){
            fast = fast.down.down;
            prevSlow = slow;
            slow = slow.down;
        }
        ListNodeX h1 = A;
        ListNodeX h2 = null;
        if(fast == null){
            h2 = slow;
            prevSlow.down = null;
        }else{
            h2 = slow.down;
            slow.down = null;
        }

        return mergeTwoLists(sortList(h1),sortList(h2));
    }

    public ListNodeX mergeTwoLists(ListNodeX A, ListNodeX B) {
        //To Solve this we need a pointer and a head
        if(A== null){
            return B;
        }
        if(B == null){
            return A;
        }
        ListNodeX head = null;
        ListNodeX p = null;
        if(A.val < B.val){
            head = A;
            p = A;
            A = A.down;
        }else{
            head = B;
            p = B;
            B = B.down;
        }
        while(A != null & B != null){
            if(A.val<B.val){
                p.down = A;
                p = p.down;
                A = A.down;
            }else{
                p.down = B;
                p = p.down;
                B = B.down;
            }
        }
        while(A != null){
            p.down = A;
            p = p.down;
            A = A.down;
        }
        while( B!=null){
            p.down = B;
            p = p.down;
            B = B.down;
        }
        return head;
    }
}
