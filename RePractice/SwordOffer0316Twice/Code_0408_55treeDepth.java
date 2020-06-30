package RePractice.SwordOffer0316Twice;

public class Code_0408_55treeDepth {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    //int res = 1;
//    public int solution(TreeNode head){
//        if (head == null){
//            return 0;
//        }
//        return res + Math.max(process(head.left) ,process(head.right) );
//
//    }

    public int process(TreeNode head){
        if (head == null){
            return 0;
        }
//        int left = process(head.left);
//        int right = process(head.right);
//        return left > right ? left + 1 : right + 1;
//
        return Math.max(process(head.left) , process(head.right)) + 1;
//        if (head.left == null || head.right == null){
//            return head.left == null && head.right == null ? 0 : 1;
//        }
//        if (head.left != null){
//            process(head.left);
//        }
    }
}
