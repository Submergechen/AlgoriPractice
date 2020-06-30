package RePractice.Tree;

public class Code_1129_getSuccessNode {
    class Node{
        private int data;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node getSuccNode(Node node){
        if (node == null){
            return node;
        }
        if (node.right != null){
            return getLeftMost(node.right);
        }else {
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if (node == null){
            return node;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
