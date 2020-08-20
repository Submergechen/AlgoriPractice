package RePractice.NewPractice_7022;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_DFS_0725_51 {
    boolean[] col;
    boolean[] d;
    boolean[] ud;
    List<List<String>> res ;
    int n;
    List<String> path;
    public List<List<String>> solveNQueens(int _n) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        n = _n;
        col = new boolean[n];
        d = new boolean[2 * n];
        ud = new boolean[2 * n];
        dfs(0);
        return res;
    }

    public void dfs(int index){
        if (index == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i < n;i++){
            if (!col[i] && !d[i + index] && !ud[index - i + n]){
                col[i] = d[i + index] = ud[index - i + n] = true;
                char[] chars = new char[n];
                Arrays.fill(chars,'.');
                chars[i] = 'Q';
                path.add(String.valueOf(chars));
                dfs(index + 1);
                path.remove(path.size() - 1);
                col[i] = d[i + index] = ud[index - i + n] = false;
            }
        }
    }
}
