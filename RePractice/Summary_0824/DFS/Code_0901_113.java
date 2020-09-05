package RePractice.Summary_0824.DFS;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Code_0901_113 {
    List<List<Integer>>  res;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root,sum);
        return res;
    }

    public void dfs(TreeNode root,int sum){
        if (root == null){
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            res.add(path);
            path.remove(path.size() - 1);
            return;
        }

        dfs(root.left ,sum - root.val);
        dfs(root.right,sum - root.val);
        path.remove(path.size() - 1);
    }
}
