package RePractice.LeetCode_Classify.Dfs;

import java.util.ArrayList;
import java.util.List;
//第7题
public class Code_0429_7_216 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        //k 个数， n 为和
        dfs(k,1,n);
        return res;
    }

    public void dfs(int u , int start , int n){
        if (u == 0){
            if (n == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start ; i <= 9; i++){
            path.add(i);
            dfs(u - 1,i + 1, n - i);
            path.remove(path.size() - 1);
        }

    }
}
