package RePractice.LeetCode_Classify.Basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Adler32;

public class Code_0502_652 {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  //最易懂的方法，但是效率不够高
    Map<String,Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        dfs(root);
        return res;

    }
    public String dfs(TreeNode root){
        if (root == null){
            return "#";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);
        //一个数字加上字符串，会自动变成字符串字符串！！
        String tree = root.val + "," + left + ","+ right;
        map.put(tree , map.getOrDefault(tree,0) + 1);
        if (map.get(tree) == 2){
            res.add(root);
        }
        return tree;
    }

    //效率比较高的做法
    Map<String,Integer> hash;
    Map<Integer,Integer> count;
    List<TreeNode> res1;
    int cnt = 0;
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        hash = new HashMap<>();
        count = new HashMap<>();
        res1 = new ArrayList<>();
        // #  对应的是 1
        hash.put("#", ++cnt);
        dfs(root);
        return res1;

    }
    public String dfs1(TreeNode root){
        if (root == null){
            return String.valueOf(hash.get("#"));
        }
        String left = dfs1(root.left);
        String right = dfs1(root.right);
        String tree = root.val + "," + left + "," + right;
        if (!hash.containsKey(tree)){
            hash.put(tree, ++cnt);
        }
        int t = hash.get(tree);
        count.put(t,count.getOrDefault(t,0) + 1);
        if (count.get(t) == 2){
            res1.add(root);
        }
        return String.valueOf(t);
   }
}
