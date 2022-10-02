package advance.linkedlist;

public class PalindromeList {
    public int lPalin(ListNode A) {
        //create a clone in reverse order
        ListNode OHead = A;
        ListNode temp = A;
        ListNode tempNew = null;
        while(temp != null){
            ListNode newNode = new ListNode(temp.val);
            // newNode.val = temp.val;
            newNode.next = tempNew;
            tempNew = newNode;
            temp = temp.next;
        }
        temp = A;
        while(temp != null){
            if(temp.val != tempNew.val){
                return 0;
            }
            temp = temp.next;
            tempNew = tempNew.next;
        }
        return 1;
    }
}
