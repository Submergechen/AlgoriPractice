package RePractice.Tree;

import java.util.Stack;

public class Code_1202_isBST {
    public static class Node{
        private int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    //非递归版本
    public static boolean isBst(Node node){
        if (node == null){
            return true;
        }
        int pre = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || node != null){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                if (node.data > pre){
                    pre = node.data;
                }else {
                    return false;
                }
                System.out.println(node.data + " ");
                node = node.right;
            }
        }
        return true;

    }
    //递归   感觉这部分还有问题，递归的版本写的并不好
    static int pre1 = Integer.MIN_VALUE;
    public static boolean isBstt(Node node){
        boolean res = true;
        if (node == null){
            return res;
        }
        isBstt(node.left);
        if (node.data > pre1){
            pre1 = node.data;
        }else {
            res = false;
        }
        isBstt(node.right);
        return res;
    }
}
