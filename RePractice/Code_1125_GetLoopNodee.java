package RePractice;

public class Code_1125_GetLoopNodee {

    class Node{
        private int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public static Node getIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }
        if (loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }

    public static Node noLoop(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1 != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            n--;
            cur2 = cur2.next;
        }
        cur1 = n > 0 ? head1: head2;
        cur2 = cur1 == head1 ? head2:head1;
        n = Math.abs(n);
        while (n > 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1,Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2){
            return noLoop(head1,head2);
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return cur1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }


    public static Node getLoopNode(Node head){
        if (head.next == null || head.next.next == null){
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while (fast != slow){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;


    }
}
