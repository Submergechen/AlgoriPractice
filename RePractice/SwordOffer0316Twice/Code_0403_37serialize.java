package RePractice.SwordOffer0316Twice;

public class Code_0403_37serialize {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void solution(TreeNode root){
        if (root == null){
            return;
        }
        process(root);
    }
    public void process(TreeNode root){
        if (root == null){
            System.out.println("$,");
            return;
        }
        System.out.println(root.value + ',');
        process(root.left);
        process(root.right);
    }

    public void rebulidTree(String str){
        if (str != null){
            String[] datas = str.split()
        }
    }
}
