package RePractice.LeetCode_Classify.Tree;

public class Code_0421_8_124 {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int  dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right + root.val);
        return Math.max(0 , root.val + Math.max(left,right));
    }
}
