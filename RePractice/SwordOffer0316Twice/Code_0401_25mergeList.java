package RePractice.SwordOffer0316Twice;

public class Code_0401_25mergeList {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    // 2020 0401写的这个版本比上次写的好很多 我自己感觉
    // 再写一个递归版本
    public Node solution(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }
//        if (head1 == null && head2 != null){
//            return head2;
//        }
//        if (head1 != null && head2 == null){
//            return head1;
//        }
//        if (head1 == null && head2 == null){
//            return null;
//        }

        Node newHead = null;
        Node cur = newHead;
        Node cur1 = head1;
        Node cur2 = head2;

        while (cur1 != null && cur2 != null){
            if (cur1.value < cur2.value){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else if (cur1.value > cur2.value){
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }

        //这里不用一个个连接起来l ！
        if (cur1 != null){
            cur.next = cur1;
        }

        if (cur2 != null){
            cur.next = cur2;
        }

        return newHead;
//        while (cur1 != null){
//            cur.next = cur1;
//            cur = cur.next;
//            cur1 = cur1.next;
//        }

//        while (cur2 != null){
//            cur.next = cur2;
//            cur = cur.next;
//            cur2 = cur2.next;
//        }
//        return newHead;
    }
    // 递归版本
    public Node process(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return  head1 == null ? head2: head1;
        }

        if (head1.value <= head2.value){
            head1.next = process(head1.next,head2);
            return head1;
        }else {
            head2.next = process(head1.next,head2);
            return head2;
        }
    }
}
