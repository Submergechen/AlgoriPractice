package RePractice.SwordOffer;

public class Code_1221_23meetingNode {
    class Node{
        private int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node meetingNode(Node head){
        //这里忘记写 head.next 和head.next.next了
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node fast = head , slow = head;
        fast = fast.next.next;
        slow = slow.next;

        while (fast != slow){
            if (fast.next.next  == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while ( fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
