package RePractice.LeetCode_Classify.Tree;

import javax.sound.midi.Track;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_0420_1_98 {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode root , long minv, long maxv){
        if (root == null){
            return true;
        }
        if (root.val < minv || root.val > maxv){
            return false;
        }
        return dfs(root.left,minv,root.val - 1L) && dfs(root.right,root.val + 1L ,maxv);
    }
//    public boolean isValidBST(TreeNode root) {
//        if (root == null){
//            return false;
//        }
//        Stack<TreeNode> q = new Stack<>();
//        int pre_data = Integer.MIN_VALUE;
//        TreeNode cur = root;
//        while (root != null || !q.isEmpty()){
//            if (cur != null){
//                q.push(cur);
//                cur = cur.left;
//            }else {
//                cur = q.pop();
//                if (cur.val < pre_data){
//                    return false;
//                }else {
//                    pre_data = cur.val;
//                }
//                cur = cur.right;
//            }
//        }
//        return true;
//    }
    //！！！
    public boolean isValidBST1(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //leetcode里面这个 数据不正确！！ 设定了一个最小值！！
//        Integer pre_data = null;
        int pre_data = Integer.MIN_VALUE;
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                if (root.val - 1L < pre_data){
                    return false;
                }else {
                    pre_data = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }

}
