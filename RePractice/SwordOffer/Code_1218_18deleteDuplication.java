package RePractice.SwordOffer;

public class Code_1218_18deleteDuplication {
    class Node{
        private int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    //删除指定节点
    public Node deleteSpecifyNode(Node head , Node deleteOne){
        if (head == null || deleteOne == null){
            throw new RuntimeException("给定的链表为空或要删除的节点为空！");
        }
        //删除的为头节点
        if (head.next == null ){
            head = null;
            return head;
        }
        //删除的是尾节点
        if (deleteOne.next == null){
            Node cur = head;
            while (cur.next != deleteOne){
                cur = cur.next;
            }
            cur.next = null;
            return head;
        }
        //普通情况
        Node temp = deleteOne.next;
        deleteOne.value = temp.value;
        deleteOne.next = temp.next;
        return head;
    }



    //delete duplication Nodes
    public  Node delete(Node head){
        //为null或者只有一个的情况 ，同时适用 ！ 边界条件先写
        if (head == null || head.next == null){
            return head;
        }
        //保证重复值出现在头部时，也可以正常
        Node phead = new Node(-1);
        phead.next = head;

        Node p = phead;
        while (p.next != null){
            Node q = p.next;
            //一直往下跳
            while (q != null && p.next.value == q.value){
                q = q.next;
            }
            if (p.next.next == q){
                p = p.next; //如果没有重复的值，p直接后移一个就行
            }else {
                p.next = q;//如果有重复的值，p的next直接跳到q的位置
            }
        }
        return phead.next;
    }
}
