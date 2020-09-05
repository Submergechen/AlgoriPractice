package RePractice.Summary_0824.DFS;

public class Code_0901_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return dfs(root.left,root.right);
    }


    public boolean dfs(TreeNode root1,TreeNode root2){
        if (root1 == null || root2 == null){
            return root1 == null && root2 == null;
        }

        return root1.val == root2.val && dfs(root1.left,root2.right) && dfs(root1.right,root2.left);

    }
}
