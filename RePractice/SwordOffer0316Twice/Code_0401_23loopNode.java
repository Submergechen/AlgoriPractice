package RePractice.SwordOffer0316Twice;

public class Code_0401_23loopNode {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public Node meetingNode(Node head1 , Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 != null || loop2 != null){
            return bothLoop(head1,head2,loop1,loop2);
        }
        if (loop1 == null && loop2 == null){
            return noLoop(head1 ,head2);
        }
        return null;

    }

    public Node bothLoop(Node head1 , Node head2 ,Node loop1 ,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1  != loop1){
                cur1 = cur1.next;
                n++;
            }
            while (cur2 != loop2){
                cur2 = cur2.next;
                n--;
            }
            cur1 = n > 0 ? head1:head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n > 0){
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1 ){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    //两个无环的相交问题
    public Node noLoop(Node head1, Node head2){
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
            cur2 = cur2.next;
            n--;
        }
        if (cur1 != cur2){
            return null;
        }
        Node longOne = n > 0 ? head1 : head2;
        Node shortOne = longOne == head1 ? head2 : head1;
        //n可能是小于0的
        n = Math.abs(n);
        while (n > 0){
            longOne = longOne.next;
            n--;
        }
        while (shortOne != longOne){
            shortOne = shortOne.next;
            longOne = longOne.next;
        }
        return longOne;


    }
    //判断是否有环，一个是hashmap ， 一个用两个指针
    public Node getLoopNode(Node head){
//        if (head == null){
//            return null;
//        }
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while (fast != slow && fast != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null){
            return null;
        }else {
            fast = head;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
