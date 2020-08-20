package RePractice.NewPractice_7022;

import java.util.LinkedList;
import java.util.Queue;

public class Code_Tree_0722_116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for (int i = 0;i < size;i++){
                Node cur = queue.poll();
                if (cur.right != null){
                    queue.add(cur.right);
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }

                cur.next = pre;
                pre = cur;

            }
        }
        return root;
    }
}
