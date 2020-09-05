package RePractice.Summary_0824.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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
public class Code_0824_99 {
    int x = -1,y = -1;
    public void recoverTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        findTwoNums(res);
        recover(root);
    }
    public void inorder(TreeNode root , List<Integer> temp){
        if (root == null){
            return;
        }
        inorder(root,temp);
        temp.add(root.val);
        inorder(root,temp);
    }
    public void findTwoNums(List<Integer> nums){
        for (int i = 0;i < nums.size() - 1;i++){
            if (nums.get(i) > nums.get(i + 1)){
                y = nums.get(i + 1);
                if (x == -1){
                    x = nums.get(i);
                }else {
                    break;
                }
            }
        }
    }
    public void recover(TreeNode root){
        if (root == null){
            return;
        }
        if (root.val == x){
            root.val = y;
        }else if (root.val == y){
            root.val = x;
        }
        recover(root.left);
        recover(root.right);

    }
}
