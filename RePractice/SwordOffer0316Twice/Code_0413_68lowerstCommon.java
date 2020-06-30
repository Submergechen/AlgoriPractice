package RePractice.SwordOffer0316Twice;

public class Code_0413_68lowerstCommon {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

//    public TreeNode solution(TreeNode head ,TreeNode A , TreeNode B){
//        if (head == null){
//            return null;
//        }
//        if (A == null || B == null){
//            return A == null ? B : A;
//        }
//        if (process(head,A,B) != null){
//            return process(head,A,B);
//        }
//        process(head.left,A,B);
//        process(head.right,A,B);
//
//    }
//
//    public TreeNode process(TreeNode head,TreeNode A , TreeNode B){
//        if (head == A || head == B){
//            return head == A ? A : B;
//        }
//
//    }
    //所有二叉树
    public TreeNode process(TreeNode root ,TreeNode p , TreeNode q){
        if (root == null){
            return null;
        }
        if (p == root || q == root){
            return root;
        }
        TreeNode leftNode = process(root.left,p,q);
        TreeNode rightNode = process(root.right,p,q);
        if (leftNode != null && rightNode != null){
            return root;
        }
//        if (leftNode == head || rightNode == head){
//            return head;
//        }
        if (leftNode != null){
            return leftNode;
        }
        return rightNode;
    }
//考虑搜索二叉树
    class Solution {
        /*
        LCA: 要么在root的左子树中, 要么在root的右子树中, 要么是root
        */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null)
                return null;
            //
            while(root!=null){
                if(p.val > root.val && q.val > root.val)
                    root = root.right;
                else if(p.val < root.val && q.val < root.val)
                    root = root.left;
                else
                    break;
            }
            return root;
        }
    }

}
