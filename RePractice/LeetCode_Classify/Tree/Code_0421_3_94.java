package RePractice.LeetCode_Classify.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code_0421_3_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        //注意这个写法！！ 不能写return null
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                root = cur.right;
            }

        }
        return res;
    }
}
