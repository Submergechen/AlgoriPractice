package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_Tree_0722_113 {

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
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
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
        if (root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        dfs(root.left,sum - root.val);
        dfs(root.right,sum - root.val);
        path.remove(path.size() - 1);
    }
}
