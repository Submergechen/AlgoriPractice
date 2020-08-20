package RePractice.NewPractice_7022;

import java.util.*;

public class Code_Tree_0728_103 {

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
    //直接reverse！
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        int level = 1;
        left.add(root);
        while (!left.isEmpty() || !right.isEmpty()){
            List<Integer> path = new ArrayList<>();
            if (level % 2 == 1){
                while (!left.isEmpty()){
                    TreeNode cur = left.pop();
                    path.add(cur.val);
                    if (cur.left != null){
                        right.add(cur.left);
                    }
                    if (cur.right != null){
                        right.add(cur.right);
                    }
                }
                res.add(path);
                level++;
            }else {
                while (!right.isEmpty()){
                    TreeNode cur = right.pop();
                    path.add(cur.val);
                    if (cur.right != null){
                        left.add(cur.right);
                    }
                    if (cur.left != null){
                        left.add(cur.left);
                    }
                }
                res.add(path);
                level++;
            }
        }
        return res;
    }
//直接reverse
    //偶数层reverse
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> path = new ArrayList<>();
            int size = queue.size();
            for (int i = 0;i < size;i++){
                TreeNode cur = queue.poll();
                path.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            if (level % 2 == 0){
                Collections.reverse(path);
            }
            res.add(path);
            level++;
        }
        return res;
    }
}
