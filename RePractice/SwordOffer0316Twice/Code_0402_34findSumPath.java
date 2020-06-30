package RePractice.SwordOffer0316Twice;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Code_0402_34findSumPath {
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> solution(TreeNode root , int sum){
        if (root == null || sum < 1){
            return null;
        }

        process(root, sum);
        return res;
    }

    //这里bu用sum 用一个target 一直相减特别好
    public void process(TreeNode root , int target ){
        if (root == null){
            return;
        }
        path.add(root.value);
        target -= root.value;

        if (target == 0 && root.left == null && root.right == null){
            res.add(path);
        }

            process(root.left , target);
            process(root.right , target);

        path.remove(path.size() - 1);
        //这个target 不用管 ，传过来的是标量 不是地址
        //target += root.value;
//        if (root.left == null && root.right == null && sum > k){
//            result.remove(result)
//        }
    }
}

public class Solution {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int sum) {
        if(root == null) return listAll;
        list.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        list.remove(list.size()-1);
        return listAll;
    }
}


