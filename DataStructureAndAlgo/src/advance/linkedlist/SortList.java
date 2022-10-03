package advance.linkedlist;

public class SortList {
    public class Solution {
        public ListNode sortList(ListNode A) {

            if(A==null || A.next == null){
                return A;
            }
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

            return mergeTwoLists(sortList(h1),sortList(h2));
        }

        public ListNode mergeTwoLists(ListNode A, ListNode B) {
            //To Solve this we need a pointer and a head
            if(A== null){
                return B;
            }
            if(B == null){
                return A;
            }
            ListNode head = null;
            ListNode p = null;
            if(A.val < B.val){
                head = A;
                p = A;
                A = A.next;
            }else{
                head = B;
                p = B;
                B = B.next;
            }
            while(A != null & B != null){
                if(A.val<B.val){
                    p.next = A;
                    p = p.next;
                    A = A.next;
                }else{
                    p.next = B;
                    p = p.next;
                    B = B.next;
                }
            }
            while(A != null){
                p.next = A;
                p = p.next;
                A = A.next;
            }
            while( B!=null){
                p.next = B;
                p = p.next;
                B = B.next;
            }
            return head;
        }
    }
}
