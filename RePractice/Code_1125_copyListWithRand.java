package RePractice;

import java.util.HashMap;

public class Code_1125_copyListWithRand {
    // 11.26再写一遍



















    public static class Node{
        private int value;
        Node next;
        Node rand;

        public Node(int value, Node next, Node rand) {
            this.value = value;
            this.next = next;
            this.rand = rand;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node copyList(Node head){
        HashMap<Node,Node> hashMap = new HashMap<>();
        Node cur = head;
        while (cur != null){
            hashMap.put(cur,new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).rand = hashMap.get(cur.rand);
            cur = cur.next;
        }
    }

    public static Node copyList2(Node head){
        if (head == null){
            return head;
        }
        //第一步，把复制的1'节点放在1节点后面
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next= new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        //连接rand指针
        cur = head;
        Node copyNode = null;
        while (cur != null){
            copyNode = cur.next;
            copyNode.rand = cur.rand == null? null :cur.rand.next;
            cur = copyNode.next;
        }

        //分开各节点
        Node res  = head.next;
        cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = next.next;
            cur.next = next == null ? null :next.next.next;
            cur = next.next;
        }
        return res;
    }

}
