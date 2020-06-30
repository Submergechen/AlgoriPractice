package RePractice.SwordOffer0316Twice;

import com.sun.tools.hat.internal.model.Root;

public class Code_0401_27mirror {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void Mirror(TreeNode head){
        if (head == null){
            return ;
        }
        /*
        TreeNode newHead = head;
        newHead.left = Mirror(head.right);
        newHead.right = Mirror(head.left);

        return newHead;*/
        TreeNode temp = head.left;
        head.left = head.right;
        head.right = temp;
        Mirror(head.left);
        Mirror(head.right);

    }
    public  TreeNode solution(TreeNode head){
        if (head == null){
            return null;
        }
        if (head.right == null && head.left == null){
            return head;
        }
        return process(head);
    }

    public TreeNode process(TreeNode node){
        if (node == null){
            return null;
        }
        TreeNode root = node;
        root.left = process(node.right);
        root.right = process(node.left);
        return root;
    }
}
