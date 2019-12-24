package RePractice.SwordOffer;

// 这里再写一次 ，还不是很熟悉
// 递归的使用
public class Code_1222_26hasSubTree {
    class TreeNode{
        private int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public boolean isSubTree(TreeNode A, TreeNode B){
        if (A == null || B == null){
            return false;
        }
        if (isPart(A,B)) {
            return true;
        }
        return isSubTree(A.left, B) || isSubTree(A.right , B);

    }

    public boolean isPart(TreeNode A,TreeNode B){
        if (B == null){
            return true;
        }
        if (A != null && A.value != B.value ){
            return false;
        }

        return isPart(A.left , B.left) && isPart(A.right , B.right);
    }
}
