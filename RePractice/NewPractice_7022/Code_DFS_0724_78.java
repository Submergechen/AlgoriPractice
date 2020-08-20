package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_DFS_0724_78 {
    List<List<Integer>> res;

    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums,0,path);
        return res;
    }

    public void dfs(int[] nums , int index,List<Integer> path){
        if (index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(nums,index + 1 , path );
        path.remove(path.size() - 1);
        dfs(nums,index + 1 , path );

    }
}
