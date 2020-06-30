package RePractice.LeetCode_Classify.Dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_0429_6_90 {
    //枚举出现的次数进行递归！
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }

    public void dfs(int[] nums, int u){
        if (u == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        int k = 0;
        while (u + k < nums.length && nums[u + k] == nums[u]){
            k++;
        }
        // k = 1 是成立的！
        for (int i = 0; i <= k; i++){
            dfs(nums , u + k);

            path.add(nums[u]);
        }

        for (int i = 0 ;i <= k; i++){
            //k = 1 的时候 加了两次，所以也要删除两次，但是递归是 未加还要加一次的情况！
            path.remove(path.size() - 1);
        }
    }
}
