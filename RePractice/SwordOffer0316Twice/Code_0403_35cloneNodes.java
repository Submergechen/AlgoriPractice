package RePractice.SwordOffer0316Twice;

import java.util.HashMap;

public class Code_0403_35cloneNodes {
    class Node{
        int value;
        Node next;
        Node random;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node solution(Node head){
        if (head == null){
            return null;
        }

        HashMap<Node,Node> copyNode = new HashMap<Node,Node>();
        Node cur = head;
        while (cur != null){
            copyNode.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        //自己现在写的
        Node newHead = copyNode.get(head);
        Node newCur = newHead;
        cur = head;
        while (cur != null){
            newCur.next = copyNode.get(cur.next);
            newCur.random = copyNode.get(cur.random);
            cur = cur.next;
            newCur = newCur.next;
        }
        //newCur.next = null;
        //newCur.random = null;
        return newHead;
        //之前写的
        //连接next
//        cur = head;
//        while (cur != null){
//            hashMap.get(cur).next = hashMap.get(cur.next);
//            hashMap.get(cur).rand = hashMap.get(cur.rand);
//            cur = cur.next;
//        }
//        return hashMap.get(head);
    }

    public Node solution2(Node head){
        if (head == null){
            return head;
        }

        //复制next
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            Node copyNode = new Node(cur.value);
            cur.next = copyNode;
            copyNode.next = next;
            cur = copyNode.next;
        }

        //random
        cur = head;
        while (cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        //连接
        cur = head;
        Node copyNode;
        while (cur != null){
            copyNode = cur.next;
            next = copyNode.next;
            // 还原原来的链接
            cur.next = next;
            //这里的next不一定存在
            copyNode.next = next == null ? null : next.next;
            cur = next;
        }
        return head.next;

    }
}
