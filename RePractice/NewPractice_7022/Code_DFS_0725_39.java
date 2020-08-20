package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_DFS_0725_39 {
    List<List<Integer>> res;

    List<Integer> path;
    int start = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(candidates, target,start);
        return res;
    }

    public void dfs(int[] candidates, int target ,int start){
        if (target <= 0){
            if (target == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start;i < candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,target - candidates[i],i);
            path.remove(path.size() - 1);
        }
    }
}
