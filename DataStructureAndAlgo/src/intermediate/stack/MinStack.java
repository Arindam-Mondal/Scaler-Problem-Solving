package intermediate.stack;

public class MinStack {
    class Node {
        int x;
        Node next;
        public Node(int x){
            this.x = x;
            this.next = null;
        }
    }

    Node head;
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        if(x<min) {
            min = x;
        }
    }

    public void pop() {
        if(head != null){
            if(min == head.x){
                min = Integer.MAX_VALUE;
            }
            head = head.next;
            getMin();
        }

    }

    public int top() {
        if(head == null){
            return -1;
        }
        return head.x;
    }

    public int getMin() {
        if(head == null){
            return -1;
        }else if(min != Integer.MAX_VALUE){
            return min;
        }
        Node temp = head;
        while(temp != null){
            if(temp.x < min){
                min = temp.x;
            }
            temp = temp.next;
        }
        return min;
    }
}
