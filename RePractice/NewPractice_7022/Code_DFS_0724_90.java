package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_DFS_0724_90 {
    List<List<Integer>> res;

    List<Integer> path;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }

    public void dfs(int[] nums , int index){
        if (index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);
        dfs(nums,index + 1);
        path.remove(path.size() - 1);
        while (index + 1 > 0 && nums[index] == nums[index + 1]){
            index++;
        }
        dfs(nums,index + 1);
    }



    //枚举出现的次数进行递归！
    List<List<Integer>> res1 = new ArrayList<List<Integer>>();
    List<Integer> path1 = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }

    public void dfs1(int[] nums, int u){
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
