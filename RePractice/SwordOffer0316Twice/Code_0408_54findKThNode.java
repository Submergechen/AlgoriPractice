package RePractice.SwordOffer0316Twice;

public class Code_0408_54findKThNode {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    TreeNode res ;
    public TreeNode solution(TreeNode head , int k){
        if (head == null){
            return null;
        }

    }

    public void process(TreeNode head , int k){
        if (head == null){
            return ;
        }
        process(head.left , k );
        k--;
        if (k == 0){
            res = head;
        }
        //剪枝，只要没有找到结果的时候才遍历右节点
        if (k > 0 ) process(head.right, k );


    }
}
