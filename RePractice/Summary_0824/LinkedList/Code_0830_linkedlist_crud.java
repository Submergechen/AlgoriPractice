package RePractice.Summary_0824.LinkedList;

public class Code_0830_linkedlist_crud {
    Node head = null;
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    int len = 0;
    public  void length(Node head){
        Node cur = head;
        while (cur != null){
            cur = cur.next;
            len++;
        }
    }
    public void addNode(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
    }

    public Node deleteNode(int index){
        if (index < 1 || index > len){
            throw new RuntimeException("error");
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cur = dummy;
        index--;
        while (index-- > 0){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;

    }
    public void update(int index,int temp){
        if (index < 1 || index > len){
            throw new RuntimeException("error");
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cur = dummy;
        while (index-- > 0){
            cur = cur.next;
        }
        cur.val = temp;
        return;

    }

    public int findNode(int value){
        int index = 1;
        Node cur = head;
        while (cur.val != value){
            cur = cur.next;
        }
        return index == len + 1 ? -1 : index;
    }
}
