package RePractice.SwordOffer0316Twice;

public class Code_0408_55isBalancedTree {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    //比较正常de思考方法
    public boolean isBTree(TreeNode head){
        if (head == null){
            return true;
        }
        int left = TreeDepth(head.left);
        int right = TreeDepth(head.right);
        if (Math.abs(left - right) > 1){
            return false;
        }
        return isBTree(head.left) && isBTree(head.right);
    }

    public int TreeDepth(TreeNode head){
        if (head == null){
            return 0;
        }
        return Math.max(TreeDepth(head.left) , TreeDepth(head.right)) + 1;
    }
    //比较好的解法！
    // 在求深度的过程中，判断是否是一棵平衡二叉树！ 用一个全局变量即可！
    boolean res = true;
    public boolean isbal(TreeNode head){
        if (head == null){
            return true;
        }
        dfs(head);
        return res;
    }

    public int dfs(TreeNode head){
        if (head == null){
            return 0;
        }
        int left = dfs(head.left);
        int right = dfs(head.right);
        if (Math.abs(left - right) > 1){
            res = false;
        }
        return Math.max(left, right ) + 1;
    }
    //感觉这种思考方法，不是很容易想出来 ！
    // 重点在于，如果一棵树的左子树或者右子树不是平衡树，那么总体就不是平衡树
    // 而且如果高度相差大于1 整体也就不是一棵平衡树
    // 最后判断 完所有不是的情况，就可以直接认定是true

    class ReturnData{
        int depth;
        boolean isBalancedTree;

        public ReturnData(int depth, boolean isBalancedTree) {
            this.depth = depth;
            this.isBalancedTree = isBalancedTree;
        }
    }
    public boolean solution(TreeNode head){
        if (head == null){
            return false;
        }
        return process(head).isBalancedTree;
    }
    public ReturnData process(TreeNode head){
        if (head == null){
            return new ReturnData(0,true);
        }
//        if (head == null){
//            return null;
//        }
        //boolean isB = true;
        ReturnData left = process(head.left);
        ReturnData right = process(head.right);
        //这里没有考虑
        //只要有一棵不是 那整体就不是
        if (!left.isBalancedTree || !right.isBalancedTree){
            //isB = false;
            return new ReturnData(0,false);
        }
        //如果这棵树不是，那么直接返回即可
        if (Math.abs(left.depth - right.depth) > 1){
            //isB = false;
            return new ReturnData(0,false);
        }
        return new ReturnData(Math.max(left.depth , right.depth) + 1, true );
    }
}
