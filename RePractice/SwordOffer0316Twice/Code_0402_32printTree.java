package RePractice.SwordOffer0316Twice;

import java.util.*;

public class Code_0402_32printTree {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    //正常打印 ,用一个队列保存即可
    public void solution(TreeNode root){
        if (root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.value + " ");
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }

        }
    }
    // 一层一换行的打印方式  ,两个参数就搞定，一个 curPrint  一个toBePrint
    public void solution2(TreeNode root){
        if (root == null){
            return;
        }

        int curPrintNumb = 1;
        int toBePrint = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.value + " ");
            curPrintNumb--;
            if (cur.left != null){
                queue.add(cur.left);
                toBePrint++;
            }
            if (cur.right != null){
                queue.add(cur.right);
                toBePrint++;
            }
            if (curPrintNumb == 0){
                System.out.println();
                curPrintNumb = toBePrint;
                toBePrint = 0;
            }

        }
    }
    //定义两个栈空间，第一个栈保存奇数层的节点，并且是先保存左子树的节点，再保存右子树的接待你；
    //第二个栈保存的是偶数层的节点，先保存右子树的节点，再保存左子树的节点。 并且在一个if 判断句里面 ，用一个while一次性打印完！
    public void solution3(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stackOdd = new Stack<>();
        Stack<TreeNode> stackEven = new Stack<>();
        int level = 1;
        stackOdd.add(root);
        while (!stackOdd.isEmpty() || !stackEven.isEmpty()){
            if (level % 2 == 1){
                TreeNode cur = stackOdd.pop();
                System.out.println(cur.value + " ");
                if (cur.left != null){
                    stackEven.add(cur.left);
                }
                if (cur.right != null){
                    stackEven.add(cur.right);
                }
            }else {
                TreeNode cur = stackEven.pop();
                System.out.println(cur.value + " ");
                if (cur.right != null){
                    stackOdd.add(cur.left);
                }
                if (cur.left != null){
                    stackOdd.add(cur.right);
                }
            }
            if (stackEven.isEmpty() || stackOdd.isEmpty()){
                System.out.println();
                level++;
            }
        }
    }
    public void solution4(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stackOdd = new Stack<>();
        Stack<TreeNode> stackEven = new Stack<>();
        List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int level = 1;
        stackOdd.add(root);
        ArrayList<Integer> levelResult = new ArrayList<Integer>();
        while (!stackOdd.isEmpty() || !stackEven.isEmpty()){
            if (level % 2 == 1){
                TreeNode cur = stackOdd.pop();
                levelResult.add(cur.value);
                if (cur.left != null){
                    stackEven.add(cur.left);
                }
                if (cur.right != null){
                    stackEven.add(cur.right);
                }
            }else {
                TreeNode cur = stackEven.pop();
                System.out.println(cur.value + " ");
                levelResult.add(cur.value);
                if (cur.right != null){
                    stackOdd.add(cur.left);
                }
                if (cur.left != null){
                    stackOdd.add(cur.right);
                }
            }
            if (stackEven.isEmpty() || stackOdd.isEmpty()){
                res.add(levelResult);
                levelResult = null;
                level++;
            }
        }
        return res;
    }
}
