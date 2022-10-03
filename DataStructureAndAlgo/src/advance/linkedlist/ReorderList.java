package advance.linkedlist;

/**
 * Problem Description
 * Given a singly linked list A
 *
 *  A: A0 → A1 → … → An-1 → An
 * reorder it to:
 *
 *  A0 → An → A1 → An-1 → A2 → An-2 → …
 * You must do this in-place without altering the nodes' values.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the linked list A.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the modified linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [1, 2, 3, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 5, 2, 4, 3]
 * Output 2:
 *
 *  [1, 4, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The array will be arranged to [A0, An, A1, An-1, A2].
 * Explanation 2:
 *
 *  The array will be arranged to [A0, An, A1, An-1, A2].
 */
public class ReorderList {
    public ListNode reorderList(ListNode A) {
        //First Fine the middle and diide the list into two list.
        ListNode slow = A;
        ListNode fast = A;
        ListNode prevSlow = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        ListNode h1 = A;
        ListNode h2 = null;
        if(fast == null){
            h2 = slow;
            prevSlow.next = null;
        }else{
            h2 = slow.next;
            slow.next = null;
        }

        //Reverse the second List
        h2 = reverseList(h2);

        //Merge the list
        ListNode curr = h1;
        ListNode temp = h2;
        while(h2!=null){
            temp = h2;
            h2 = h2.next;
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        return h1;

    }

    public ListNode reverseList(ListNode A){
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = curr == null ? null : curr.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr == null ? null : curr.next;
        }
        return prev;
    }
}
