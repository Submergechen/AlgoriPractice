package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_DFS_0725_40 {
    List<List<Integer>> res;

    List<Integer> path;
    int start = 0;
    boolean[] is_visited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates);
        is_visited = new boolean[candidates.length];
        dfs(candidates,target,start);
        return res;
    }

    public void dfs(int[] candidates, int target,int start){
        if (target <= 0){
            if (target == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start;i < candidates.length;i++){
            if (i > 0 && candidates[i] == candidates[i - 1] && !is_visited[i - 1]){
                continue;
            }
            is_visited[i] = true;
            path.add(candidates[i]);
            dfs(candidates,target - candidates[i],i + 1);
            path.remove(path.size() - 1);
            is_visited[i] = false;
        }
    }
}
