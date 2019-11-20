package RePractice;

public class Code_1120_ReverseLinkedList {
    class Node{
        private int value;
        Node next;
        Node last;

        public Node(int value, Node next, Node last) {
            this.value = value;
            this.next = next;
            this.last = last;
        }
    }
    //反转单向链表，从头节点的下一个节点开始
    public static Node reverseList(Node head){
        Node pre = head;
        Node cur = head.next;
        pre.next = null;
        while (cur.next != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //反转双向链表 ， 从头节点开始反转
    public static Node reverseDoubleList(Node head) {
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

    }
}
