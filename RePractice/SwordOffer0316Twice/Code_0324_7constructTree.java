package RePractice.SwordOffer0316Twice;

import java.util.Stack;

public class Code_0324_7constructTree {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    public void solution(int[] preorder ,int[] inorder){
        if (preorder.length < 1 || inorder.length < 1 || preorder == null || inorder == null
        || preorder.length != inorder.length){
            return;
        }

        process(preorder,inorder, 0,preorder.length - 1 , 0,inorder.length - 1);
    }

    //!!  长度参数要定义好！
    public  TreeNode process(int[] preOrder ,int[] inOrder ,int startPre ,int endPre,int startIn ,int endIn){
        int root_value = preOrder[startPre];
        TreeNode root = new TreeNode(root_value);
        int left_length = 0;
        int i = startIn;
        //这里每一次都要找！ 时间复杂度很高！！
        while (inOrder[i] != root_value){
            i++;
            left_length++;
        }
        int right_length = preOrder.length - left_length - 1;

        // 如果left_length < 0  默认root.left = null
        if (left_length > 0){
            root.left = process(preOrder,inOrder,startPre + 1,startPre + left_length ,
                    startIn,startIn + left_length - 1 );
        }
        if (right_length > 0 ){
            root.right = process(preOrder,inOrder,startPre + 1 + left_length, endPre ,
                    startIn + left_length + 1, endIn);
        }
        return root;
    }
}
