package RePractice.SwordOffer;

public class Code_1218_8getNextNodeInTree {
    class TreeNode{
        private int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode getNext(TreeNode node){
        if (node == null){
            return null;
        }
        //如果有右子树
        if (node.right != null){
            TreeNode cur = node.right;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }else {
            //如果没有右子树
            TreeNode parent = node.parent;
            TreeNode cur = node;
            while (parent != null && parent.left != cur){
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
}
