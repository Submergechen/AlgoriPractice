package RePractice.NewPractice_7022;

public class Code_LinkedList_0802_138 {
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    public Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }

        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;

        }

        Node dummy  = new Node(-1);
        dummy.next = head.next;
        cur = head;
        while (cur != null){
            Node next = cur.next.next;
            Node copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return dummy.next;
    }















}
