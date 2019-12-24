package RePractice.SwordOffer;

public class Code_1222_28isMirrorTree {
    class TreeNode{
        private int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public boolean isMirror(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        return process(treeNode.left, treeNode.right);
    }

    public boolean process(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.value != treeNode2.value) {
            return false;
        }
        return process(treeNode1.left, treeNode2.right) && process(treeNode1.right, treeNode2.left);
    }
}
