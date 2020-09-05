package RePractice.Summary_0824.BFS;

import java.util.LinkedList;
import java.util.Queue;

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
public class Code_0824_111 {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return dfs(root);
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return left == 0 || right == 0 ? left + right + 1 : 1 + Math.min(left,right);
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len;i++){
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            depth++;
        }
       return depth;
    }
}
