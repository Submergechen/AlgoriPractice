package RePractice.Tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.logging.Level;

public class Code_1202_BS {
    public static class Node{
        private int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static int sumNode(Node head){
        if (head == null){
            return 0;
        }
        return bs(head , 1 , mostLeftLevel(head,1));
    }

    //这里的level是当前节点所处的高度， h是整个树的最大高度 ，node是当前的节点
    //返回值是 以该node为头节点的子树 一共有多少个节点
    public static int bs(Node node ,int level , int h ){
        if (level == h)
            return 1;
        if (mostLeftLevel(node.right , level +1) == h){
            return 1 << (h - level) + bs(node.right , level +1 , h);
        }else {
            return 1 << (h - level - 1) + bs(node.left ,level + 1,h);
        }
    }

    public static int mostLeftLevel(Node node, int level){
        if (node == null){
            return 0;
        }
        while (node != null){
            level++;
            node = node.left;
        }

        return level-1;
    }
}
