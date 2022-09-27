package advance.linkedlist;

public class LinkListOperations {
    /**
     * Given a linked list of integers, find and return the middle element of the linked list.
     *
     * NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
     * @param A
     * @return
     */
    public int middleElement(ListNode A) {
        int size = 0;
        ListNode temp = A;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        // System.out.println(size);
        int position = size%2 == 0 ? (size/2) + 1 : (size+1) /2 ;

        temp = A;
        int currPosition = 1;
        while(position != currPosition){
            temp = temp.next;
            currPosition++;
        }
        return temp.val;
    }

    /**
     * Given a singly linked list, delete middle of the linked list.
     *
     * For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
     *
     * If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
     *
     * For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
     *
     * Return the head of the linked list after removing the middle node.
     *
     * If the input linked list has 1 node, then this node should be deleted and a null node should be returned.
     *
     * @param A
     * @return
     */
    public ListNode deleteMiddleElement(ListNode A) {
        ListNode temp = A;
        int size = 0;
        //find the size of the linked list
        while(temp != null){
            size++;
            temp = temp.next;
        }
        int position = size % 2 == 0 ? (size/2) + 1 : (size + 1)/2;
        if(size == 1){
            return null;
        }
        temp = A;
        int count = 1;
        while(count != position-1){
            count++;
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return A;
    }
}
