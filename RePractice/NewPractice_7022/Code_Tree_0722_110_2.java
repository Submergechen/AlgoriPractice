package RePractice.NewPractice_7022;

public class Code_Tree_0722_110_2 {

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


    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1){
            ans = false;
        }
        return 1 + Math.max(left,right);
    }

}
