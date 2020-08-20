package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_Tree_0818_Tencent {

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
    public int solution(TreeNode root){
        if (root == null){
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        //height
        int left = dfs(root.left);
        int right = dfs(root.right);

        res = Math.max(res,left + right );
        return Math.max(left,right) + 1;
    }
}
