package RePractice.LeetCode_Classify.Tree;

import java.util.Stack;

public class Code_0422_9_173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Stack<TreeNode> stack = new Stack<>();
    public Code_0422_9_173(TreeNode root) {
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.peek();
        stack.pop();
        int res = cur.val;
        cur = cur.right;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
