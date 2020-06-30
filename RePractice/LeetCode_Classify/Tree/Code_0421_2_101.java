package RePractice.LeetCode_Classify.Tree;

import java.util.Stack;

public class Code_0421_2_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //递归方式
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return process(root.left,root.right);
    }

    public boolean process(TreeNode root1,TreeNode root2){
        if (root1 == null || root2 == null){
            return root1 == null && root2 == null;
        }
        return root1.val == root2.val && process(root1.left,root2.right)
                && process(root1.right,root2.left);
    }

    //迭代方式
    public boolean isSymmetric2(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode l = root.left;
        TreeNode r = root.right;
        while (l != null || r != null || !left.isEmpty() || !right.isEmpty()){
            if (l != null && r != null){
                left.push(l);
                right.push(r);
                l = l.left;
                r = r.right;
            }else {
                if (left.isEmpty() || right.isEmpty()){
                    return false;
                }
                TreeNode curL = left.pop();
                TreeNode curR = right.pop();
                if (curL.val != curR.val){
                    return false;
                }
                l = curL.right;
                r = curR.left;
            }
        }
        return true;
    }
    //迭代方式  过不了过不了！！！
    public boolean isSymmetric3(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode l = root.left;
        TreeNode r = root.right;
        while (l != null || r != null || !left.isEmpty() || !right.isEmpty()){
            while (l != null && r != null){
                left.push(l);
                right.push(r);
                l = l.left;
                r = r.right;
            }
            if (left.isEmpty() || right.isEmpty()){
                    return false;
                }
            l = left.pop();
            r = right.pop();
            if (l.val != r.val){
                return false;
            }
            l = l.right;
            r = r.left;
        }

        return true;
    }

    //比上面的解法繁琐些！
    public boolean solution1(TreeNode root){
        if (root == null){
            return true;
        }
        return process(root.left , root.right);
    }

    public boolean process1(TreeNode root1 , TreeNode root2){
        if (root1 == null && root1 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1 == null || root2 == null){
            return root1 == null && root1 == null;
        }
        if (root1.val != root2.val){
            return false;
        }
        // 要不要判断值相等时  就是true？

        return process1(root1.left , root2.right) && process1(root1.right , root2.left);
    }
}


