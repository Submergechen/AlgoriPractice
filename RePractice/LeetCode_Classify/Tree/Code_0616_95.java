package RePractice.LeetCode_Classify.Tree;

import java.util.ArrayList;
import java.util.List;

public class Code_0616_95 {

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

    public List<TreeNode> generateTrees(int n) {
          if (n == 0){
              return null;
          }

          return dfs(1,n);
    }

    public List<TreeNode> dfs(int l ,int r){
        List<TreeNode> res = new ArrayList<>();
        if (l > r){
            res.add(null);
            return res;
        }

        for (int i = l ;i <= r; i++){

            List<TreeNode> left = dfs(l, i - 1);
            List<TreeNode> right = dfs(i + 1, r);
            for (TreeNode left1 : left){
                for (TreeNode right1 : right){
                    TreeNode cur = new TreeNode(i);
                    cur.left = left1;
                    cur.right = right1;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
