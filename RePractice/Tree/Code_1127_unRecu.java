package RePractice.Tree;

import java.util.Stack;

public class Code_1127_unRecu {
    public static class Node{
        private int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void preUnRecu(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        Node cur;
        while (!stack.isEmpty()){
             cur = stack.pop();
            System.out.println(cur.data);
            if (cur.right != null){
                stack.add(cur.right);
            }
            if (cur.left != null){
                stack.add(cur.left);
            }
        }
        System.out.println();
    }

    public static void medUnRecu(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();


        while (!stack.isEmpty() || head != null){
                if (head !=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.data);
                    head = head.right;
                }
        }
        System.out.println();
    }

    public static void postUnRecu(Node head){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        Node cur;
        while (!stack1.isEmpty()){
            cur = stack1.pop();
            if (cur.left != null){
                stack1.push(cur.left);
            }
            if (cur.right != null){
                stack2.push(cur.right);
            }
            stack2.push(cur);
        }
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().data + " ");
        }
    }

}
