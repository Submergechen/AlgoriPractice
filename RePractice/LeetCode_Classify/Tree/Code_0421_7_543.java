package RePractice.LeetCode_Classify.Tree;

public class Code_0421_7_543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        return res;

    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res , left + right);
        return Math.max(left,right) + 1;
    }
}
//计算节点数了！！
    int ans;
    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
