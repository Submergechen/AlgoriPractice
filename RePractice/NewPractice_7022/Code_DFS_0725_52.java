package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_DFS_0725_52 {
    boolean[] col;
    boolean[] d;
    boolean[] ud;
    int res;
    int n;
    public int totalNQueens(int _n) {
        n = _n;
        col = new boolean[n];
        d = new boolean[2 * n];
        ud = new boolean[2 * n];
        dfs(0);
        return res;
    }

    public void dfs(int index){
        if (index == n){
            res++;
            return;
        }
        for (int i = index;i < n;i++){
            if (!col[i] && !d[i + index] && !ud[index - i + n]){
                col[i] = d[i + index] = ud[index - i + n] = true;
                dfs(index + 1);
                col[i] = d[i + index] = ud[index - i + n] = false;
            }
        }
    }
}
