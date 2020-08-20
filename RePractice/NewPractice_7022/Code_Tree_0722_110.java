package RePractice.NewPractice_7022;

public class Code_Tree_0722_110 {

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
    public class returnData{
        int height;
        boolean isB;

        public returnData(int length, boolean isB) {
            this.height = length;
            this.isB = isB;
        }
    }


    public boolean isBalanced(TreeNode root) {
        returnData res = dfs(root);
        return res.isB;
    }

    public returnData dfs(TreeNode root){
        if (root == null){
            return new returnData(0,true);
        }
        int height;
        boolean is_balanced = true;
        returnData left = dfs(root.left);
        returnData right = dfs(root.right);
        if (Math.abs(left.height - right.height) > 1 || !left.isB || !right.isB){
            is_balanced = false;
        }
        height = 1 +  Math.max(left.height,right.height);
        return new returnData(height,is_balanced);
    }
}
