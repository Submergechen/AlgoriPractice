package RePractice.SwordOffer0316Twice;

public class Code_0403_36convertNode {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //构造一种结构出来， 相当于c++里面的pair
    class Pair{
        TreeNode first;
        TreeNode second;

        public Pair(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }

    public TreeNode solution(TreeNode root){
        if (root == null){
            return null;
        }
        return process(root).first;
    }

    public Pair process(TreeNode root){
        if (root.left == null && root.right == null){
            return new Pair(root,root);
        }
        if (root.left != null && root.right != null){
            Pair leftRes = process(root.left);
            Pair rightRes = process(root.right);
            leftRes.second.right = root;
            root.left = leftRes.second;
            rightRes.first.left = root;
            root.right = rightRes.first;
            return new Pair(leftRes.first,rightRes.second);
        }
        if (root.left != null){
            Pair leftRes = process(root.left);
            leftRes.second.right = root;
            root.left = leftRes.second;
            return new Pair(leftRes.first,root);
        }
        if (root.right != null){
            Pair rightRes = process(root.right);
            rightRes.first.left = root;
            root.right = rightRes.first;
            return new Pair(root,rightRes.second);
        }
        return null;
    }

    //不使用pair的情况

    public TreeNode convert(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode leftHead = convert(root.left);
        TreeNode cur = leftHead;
        if (leftHead != null){
            while (cur.right != null){
                cur = cur.right;
            }
            cur.right = root;
            root.left = cur;
        }
        TreeNode rightHead = convert(root.right);
        root.right = rightHead;
        if (rightHead != null){
            rightHead.left = root;
        }
        return leftHead == null ? root : leftHead;
    }
}
