package intermediate.arrayproblems;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,null));
        ListNode l2 = new ListNode(1,null);
        SolutionAddTwoNumbers tn = new SolutionAddTwoNumbers();
        ListNode result = tn.addTwoNumbers(l1,l2);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class SolutionAddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode finalNode = null;
        ListNode head = null;
        ListNode next = null;
        while(l1 != null || l2 != null) {
            int v1=0;
            int v2=0;
            if(l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            int value = sum % 10;
            if(finalNode == null) {
                finalNode = new ListNode(value,null);
                head = finalNode;
            }else {
                ListNode newListNode= new ListNode(value, null);
                finalNode.next = newListNode;
                finalNode = finalNode.next;
            }
            carry = sum /10;

        }
        if (carry > 0) {
            ListNode newListNode= new ListNode(carry, null);
            finalNode.next = newListNode;
        }
        return head;
    }
}
