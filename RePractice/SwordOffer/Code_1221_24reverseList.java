package RePractice.SwordOffer;

public class Code_1221_24reverseList {
    class Node{
        private int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void reverseList(Node head){
        if (head == null){
            return;
        }
        Node pre = head;
        Node cur = head.next;
        //不能直接这么写 ，不确定 cur.next是不是存在
        //Node next = cur.next;
        head.next = null;
        while (cur.next != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        pre = head;

    }
}
