

public class Code_Tree_0722_112 {

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

    public boolean hasPathSum(TreeNode root, int sum) {

        return dfs(root,sum);

    }
    public boolean dfs(TreeNode root,int sum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum){
            return true;
        }
        return dfs(root.left,sum - root.val) || dfs(root.right,sum - root.val);

    }

    //回溯！
    int res;
    public boolean hasPathSum1(TreeNode root, int sum) {
        res = sum;
        return dfs2(root);

    }
    public boolean dfs2(TreeNode root){
        if (root == null){
            return false;
        }
        res -= root.val;
        if (root.left == null && root.right == null && res == 0){
            return true;
        }
        boolean success = dfs2(root.left) || dfs2(root.right);
        if (success){
            return true;
        }else {
            res += root.val;
        }
        return false;

    }




    public boolean dfs1(TreeNode root){
        if (root == null && res == 0){
            return true;
        }
        res -= root.val;

        boolean is_success = dfs(root.left) || dfs(root.right);
        if (is_success){
            return true;
        }else {
            res += root.val;
        }
        return false;

    }
}
