package RePractice.SwordOffer;

//没写完！
public class Code_1223_34findSumPath {
    class TreeNode{
        private int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    //判断是否存在
    public boolean isExist(TreeNode root , int aim){
        if (root == null || aim < 0){
            return false;
        }
        return process(root,aim);
    }
    public boolean process(TreeNode root , int aim){
        if (root.left == null && root.right == null && aim == 0){
            return true;
        }
        aim = aim - root.value;
        return  process(root.left , aim - root.left.value) ||
                process(root.right , aim - root.right.value);
    }

}
