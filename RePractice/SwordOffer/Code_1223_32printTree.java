package RePractice.SwordOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Code_1223_32printTree {
    class TreeNode{
        private int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void print(TreeNode head){
        if (head == null ){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
            System.out.println(cur.value);
        }
    }

    public void print2(TreeNode head){

    }
}
