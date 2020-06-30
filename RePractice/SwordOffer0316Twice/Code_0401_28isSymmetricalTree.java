package RePractice.SwordOffer0316Twice;

public class Code_0401_28isSymmetricalTree {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public boolean solution(TreeNode root){
        if (root == null){
            return true;
        }
        return process(root.left , root.right);
    }

    public boolean process(TreeNode root1 , TreeNode root2){
        if (root1 == null && root1 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1 == null || root2 == null){
            return root1 == null && root1 == null;
        }
        if (root1.value != root2.value){
            return false;
        }
        // 要不要判断值相等时  就是true？

        return process(root1.left , root2.right) && process(root1.right , root2.left);
    }
}
