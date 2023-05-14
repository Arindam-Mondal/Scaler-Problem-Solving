package advance.linkedlist;

public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;

        slow = slow.next;
        fast = fast.next == null ? null : fast.next.next;

        Boolean cyclePresent = false;

        while(slow != null && fast != null){
            if(slow==fast){
                cyclePresent = true;
                break;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }

        if(cyclePresent){
            slow = a;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }else{
            return null;
        }
    }
}
