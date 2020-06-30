package RePractice.LeetCode_Classify.Tree;




public class Code_0610_222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    int count = 0;
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        //先求深度
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        //3
        int leftDepth = LeftestNodedepth(root.left);
        //2
        int rightDepth = LeftestNodedepth(root.right);
        if (rightDepth == leftDepth - 1){
            count = count + (int) Math.pow(2,rightDepth) + dfs(root.left);
        }else {
            count = count + (int) Math.pow(2,leftDepth) + dfs(root.right) ;
        }
        //2^h - 1 而不是 2^(h-1)!!
        return count;
    }

    public int LeftestNodedepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int count = 1;
        while (root.left != null){
            root = root.left;
            count++;
        }
        return count;
    }
}
