package RePractice.Tree;

public class Code_1127_Tree {
    public static class Node{
        private int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void preOrder(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.data);
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void medOrder(Node head){
        if (head == null){
            return;
        }
        medOrder(head.left);
        System.out.println(head.data);
        medOrder(head.right);
    }

    public static void postOrder(Node head){
        if (head == null){
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.println(head.data);
    }
}
