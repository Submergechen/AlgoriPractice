package RePractice.NewPractice_7022;


class TreeNode {
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
public class Code_DP_0810_337 {
    //和那个舞会最大活跃度很像！！

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dfs(TreeNode root){
        if (root == null){
            return new int[]{0,0};
        }
        //选这个 或者不选这个的最大值
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int select = root.val + left[0] + right[0];
        int notSelect = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[]{notSelect,select};
    }
   

}
