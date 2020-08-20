package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_Tree_0803_230 {

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
    List<Integer> res;
    public int kthSmallest(TreeNode root, int k) {
        res = new ArrayList<>();
        dfs(root);
        return res.get(k - 1);
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            dfs(root.left);
        }
        res.add(root.val);
        if (root.right != null){
            dfs(root.right);
        }
    }
}
