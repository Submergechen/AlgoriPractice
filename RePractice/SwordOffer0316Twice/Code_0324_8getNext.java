package RePractice.SwordOffer0316Twice;

public class Code_0324_8getNext {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    public TreeNode solution(TreeNode node){
        if (node == null){
            return null;
        }

        if (node.right != null){
            //有右子树
            TreeNode cur = node.right;
            while (cur.left!= null){
                cur = cur.left;
            }
            return cur;
        }else {
            //无右子树, 当该节点是父节点的左节点时
            TreeNode parent = node.parent;
            while (parent.left != node && parent != null){
                node = parent;
                parent = node.parent;
            }
            return parent;

        }

    }
}
