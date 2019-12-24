package RePractice.SwordOffer;

import java.util.Stack;

public class Code_1216_6printListReverse {
    class Node{
        private int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void reverseList(Node head){
        if (head == null){
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()){
            cur = stack.pop();
            System.out.println(cur.value);
        }
    }
}
