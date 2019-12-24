package RePractice.SwordOffer;

public class Code_1222_27MirrorTree {
    class TreeNode{
        private int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    /*
    public boolean isMirror(TreeNode treeNode1,TreeNode treeNode2){

        return process(treeNode1 , treeNode2);
    }

    public boolean process(TreeNode treeNode1 , TreeNode treeNode2){
        if (treeNode1 == null && treeNode2 == null){
            return true;
        }
        if (treeNode1 == null || treeNode2 == null){
            return false;
        }
        if (treeNode1.value != treeNode2.value){
            return false;
        }
        return process(treeNode1.left , treeNode2.right) && process(treeNode1.right , treeNode2.left);
    }*/

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

}
