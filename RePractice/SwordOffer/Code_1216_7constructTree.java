package RePractice.SwordOffer;

public class Code_1216_7constructTree {
    class TreeNode{
        private int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode reConstruct(int[] preOrder ,int[] inOrder){
        if (preOrder.length < 1 || inOrder.length < 1 || preOrder.length != inOrder.length){
            return null;
        }
        return process(preOrder,0,preOrder.length - 1 ,inOrder , 0 , inOrder.length - 1);
    }

    public TreeNode process(int[] preOrder , int startPre , int endPre ,
                            int[] inOrder ,int startIn , int endIn ){

        TreeNode root = new TreeNode(preOrder[startPre]);

        int rootIndex = startIn;
        while (inOrder[rootIndex] != root.value){
            rootIndex++;//index = 3
        }

        int leftLen = rootIndex - startIn;
        int rightLen = endIn - rootIndex;
        if (leftLen > 0){
            root.left = process(preOrder,startPre + 1,startPre + rootIndex,
                    inOrder,startIn,rootIndex-1);
        }
        if (rightLen > 0){
            root.right = process(preOrder,startPre+rootIndex+1,endPre,
                    inOrder,rootIndex + 1,endIn);
        }
        return root;

    }
}
