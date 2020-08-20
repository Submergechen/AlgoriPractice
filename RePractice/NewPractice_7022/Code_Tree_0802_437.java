package RePractice.NewPractice_7022;

import java.util.*;

public class Code_Tree_0802_437 {

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
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        dfs(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return res;
    }

    public void dfs(TreeNode root, int sumTemp){
        if (root == null ){
            return;
        }
        sumTemp -= root.val;
        if (sumTemp == 0){
            res++;
        }

        dfs(root.left,sumTemp);
        dfs(root.right,sumTemp);
//        dfs(root.left,sum);
//        dfs(root.right,sum);

    }
}
