package RePractice.SwordOffer0316Twice;

public class Code_0401_26hasSubTree {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

//    public boolean solution(TreeNode headA , TreeNode headB){
//        if (headA == null || headB == null){
//            return false;
//        }
////        if (headB == null){
////            return true;
////        }
//        return process(headA,headB);
//    }
//
//    public boolean process(TreeNode head1 , TreeNode head2){
//        if (head2 == null){
//            return true;
//        }
//        if (head1.value == head2.value){
//            return process(head1.left,head2.left) && process(head1.right , head2.right);
//        }
//        if (head1.value != head2.value){
//            return process(head1.left,head2) || process(head1.right , head2);
//        }
//        return false;
//    }

    public boolean hasSub(TreeNode headA , TreeNode headB){
        if (headA == null || headB == null){
            return false;
        }
        if (isPart(headA,headB)) return true;
        return hasSub(headA.left , headB) || hasSub(headA.right , headB);
    }

    public boolean isPart(TreeNode head1 , TreeNode head2){
        if (head2 == null){
            return true;
        }
        if (head1 == null || head1.value != head2.value){
            return false;
        }
        return isPart(head1.left,head2.left) && isPart(head1.right , head2.right);
    }
}
