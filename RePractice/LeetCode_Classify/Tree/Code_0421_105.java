package RePractice.LeetCode_Classify.Tree;

import java.util.HashMap;
import java.util.Map;

public class Code_0421_105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length < 1 || preorder.length != inorder.length){
            return null;
        }
        return process(preorder,inorder,0,preorder.length - 1, 0 ,inorder.length - 1);
    }

    public TreeNode process(int[] preorder, int[] inorder ,int startPre ,int endPre, int startIn ,int endIn){
        int root_value = preorder[startPre];
        TreeNode root = new TreeNode(root_value);
        int index = startIn;
        int len = 0;
        while (inorder[index] != root_value){
            index++;
            len++;
        }
        int right_length = preorder.length - len - 1;
        if (len > 0){
            root.left = process(preorder, inorder ,startPre + 1, startPre + len ,
                    startIn , startIn + len - 1) ;
        }
        if (right_length > 0){
            root.right = process(preorder, inorder , startPre + len + 1 ,endPre,
                    startIn + len + 1,endIn);
        }


        return root;
    }
//优化版本
    Map<Integer,Integer> pos = new HashMap<>();
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length < 1 || preorder.length != inorder.length){
            return null;
        }
        int n = preorder.length;
        for (int i = 0; i < n; i++){
            pos.put(inorder[i],i);
        }
        return process1(preorder,inorder,0,preorder.length - 1, 0 ,inorder.length - 1);
    }

    public TreeNode process1(int[] preorder, int[] inorder ,int pl ,int pr, int il ,int ir){
        //改了这么久 问题出在这里！！
        if (pl > pr){
            return null;
        }
        int root_value = preorder[pl];
        TreeNode root = new TreeNode(root_value);
//        int index = startIn;
//        int len = 0;
//        while (inorder[index] != root_value){
//            index++;
//            len++;
//        }
        int k = pos.get(root_value);
        int len = k - il;
//            root.left = process(preorder, inorder ,startPre + 1, startPre + len ,
//                    startIn , startIn + len - 1) ;
        root.left = process(preorder,inorder,pl + 1 ,pl + len,
                    il , k - 1);


//            root.right = process(preorder, inorder , startPre + len + 1 ,endPre,
//                    startIn + len + 1,endIn);
        root.right = process(preorder,inorder,pl + len + 1 , pr,
                    k + 1 , ir);

        return root;
    }
}
