package RePractice.LeetCode_Classify.DP;

import java.util.HashMap;
import java.util.Map;

public class Code_0601_337 {
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
    static Map<TreeNode,Map<Integer,Integer>> f = new HashMap<>();
    public int rob(TreeNode root) {

        dfs(root);
        return Math.max(f.get(root).get(0),f.get(root).get(1));
    }
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        if (f.get(root).containsKey(f.get(root).get(1))){
            f.get(root).put(f.get(root).get(1),root.val + f.get(root.left).get(0) + f.get(root.right).get(0));
        }
        if (f.get(root).containsKey(f.get(root).get(0))){
            f.get(root).put(f.get(root).get(0),Math.max(f.get(root.left).get(0),f.get(root.left).get(1))
                    + Math.max(f.get(root.right).get(0),f.get(root.right).get(1)));

        }
    }
}
