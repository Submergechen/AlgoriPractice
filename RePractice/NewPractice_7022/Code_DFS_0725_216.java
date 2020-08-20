package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_DFS_0725_216 {
    List<List<Integer>> res;

    List<Integer> path;
    int[] temp;
    boolean[] is_visited;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        is_visited = new boolean[10];
        temp = new int[10];
        for (int i = 0;i < 9;i++){
            temp[i] = i + 1;
        }
        dfs(k,0,n,0);
        return res;
    }


    public void dfs(int k , int index , int n ,int start){
        if (index == k ){
            if (n == 0){
                res.add(new ArrayList<>(path));
                return;
            }
        }


        for (int i = start;i < 9;i++ ){
            if (!is_visited[i]){
                is_visited[i] = true;
                path.add(temp[i]);
                dfs(k,index + 1,n - temp[i],i + 1);
                path.remove(path.size() - 1);
                is_visited[i] =false;
            }
        }
    }
}
