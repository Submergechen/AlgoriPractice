package RePractice.NewPractice_7022;

public class Code_Tree_0722_114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        if (left == null){
            return;
        }
        while (left.right != null){
            left = left.right;
        }
        left.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
