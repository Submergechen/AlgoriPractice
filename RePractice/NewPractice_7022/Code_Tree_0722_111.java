package RePractice.NewPractice_7022;

public class Code_Tree_0722_111 {

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
    //keng!! 坑！！ 如果一个节点的某一个节点为null ，那么至少为2  left + right + 1 这样比较好！
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return dfs(root);
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return left == 0 || right == 0 ? left + right + 1 : 1 + Math.min(left,right);
    }

}
