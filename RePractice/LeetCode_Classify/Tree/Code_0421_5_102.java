package RePractice.LeetCode_Classify.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_0421_5_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> res = new ArrayList<Integer>();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                res.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            result.add(res);
        }
        return result;
    }
}
