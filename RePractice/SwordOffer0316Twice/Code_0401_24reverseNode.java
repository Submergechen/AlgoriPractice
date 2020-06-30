package RePractice.SwordOffer0316Twice;

public class Code_0401_24reverseNode {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    //只要定义一个前驱节点，保存就可以了
    //最简洁的版本
    public Node solution(Node head){
        if (head == null){
            return null;

        }
        Node pre = null;
        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


//    public Node solution(Node head){
//        if (head == null){
//            return null;
//        }
//        Node reverseHead = null;
//        Node pre = null;
//        Node cur = head;
//        Node next = cur.next;
//        while (cur != null){
//            //
//            if (next == null){
//                reverseHead = cur;
//            }
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//            next = next.next;
//        }
//        return reverseHead;
//    }
}
