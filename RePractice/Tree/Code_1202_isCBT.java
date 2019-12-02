package RePractice.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Code_1202_isCBT {
    public static class Node{
        private int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBt(Node head){
        if (head == null){
            return false;
        }
        Queue<Node> queue = new LinkedList<>();

        Node l = null;
        Node r = null;
        boolean leaf = false;
        queue.offer(head);
        // 两种情况
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            l = cur.left;
            r = cur.right;
            if ((leaf &&(l != null || r != null))
                || (l ==null && r != null)){
                return false;
            }
            if (l != null){
                queue.offer(l);
            }
            if (r != null){
                queue.offer(r);
            }
            if (l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }
}
