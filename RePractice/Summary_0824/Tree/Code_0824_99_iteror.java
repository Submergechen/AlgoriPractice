package RePractice.Summary_0824.Tree;

public class Code_0824_99_iteror {
    TreeNode x = null;
    TreeNode y = null, pre = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    public void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (pre != null && pre.val > root.val){
            y = root;
            if (x == null){
                x = pre;
            }else {
                return;
            }
        }
        pre = root;
        inorder(root.right);
    }
}
