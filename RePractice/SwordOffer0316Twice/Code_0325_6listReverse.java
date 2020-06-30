package RePractice.SwordOffer0316Twice;

import java.util.Stack;

/**
 * 链表分为两种， 一种是带头节点的，一种是不带头节点的
 * 带头节点的链表，第一个数据域是空，不带头节点的，直接指向下一个节点
 */



public class Code_0325_6listReverse {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;

        }
    }

    public void reverse(Node head){
        if (head == null){
            return;
        }
        Node cur = head;
        Stack<Node> stack = new Stack<Node>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().value + " ");
        }

    }
}
