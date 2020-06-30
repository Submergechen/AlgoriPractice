package RePractice.LeetCode_Classify.Dfs;

import java.util.ArrayList;
import java.util.List;

public class Code_0427_5_78 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0 ,temp);
        return res;
        //  1 2 3
    }

    public void dfs(int[] nums , int index , List<Integer> temp){
        if (index == nums.length){
            //为啥要new ArrayList<>(temp)
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs(nums,index + 1, temp);
        temp.remove(temp.size() - 1);
        dfs(nums,index + 1, temp);
    }

    public List<List<Integer>> subsets2(int[] nums) {
        //利用位运算来进行枚举！
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0 ; i < 1 << nums.length; i++){
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length;j++){
                if (((i >> j) & 1) == 1){
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;

        //  1 2 3
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            helper(nums, 0, res, tmp);
            return res;
        }

        private void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> tmp) {
            if (index == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }

            tmp.add(nums[index]);
            helper(nums, index + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
            helper(nums, index + 1, res, tmp);
        }
    }
}
