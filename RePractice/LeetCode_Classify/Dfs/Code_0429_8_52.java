package RePractice.LeetCode_Classify.Dfs;

public class Code_0429_8_52 {
    //n皇后问题！
    int res = 0;
    int n;
    boolean[] col,d,ud;
    public int totalNQueens(int _n) {
        n = _n;
        col = new boolean[n];
        d = new boolean[2*n];
        ud = new boolean[2*n];
        dfs(0);
        return res;
    }

    public void dfs(int u){
        if (u == n){
            res++;
            return;
        }
        for (int i = 0;i < n;i++){
            if (col[i] == false && d[u + i] ==false && ud[u - i + n] == false){
                col[i] = d[u+i] = ud[u - i + n]  = true;
                dfs(u + 1);
                col[i] = d[u+i] = ud[u - i + n] = false;
            }
        }
    }
}
