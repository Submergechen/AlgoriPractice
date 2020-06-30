package RePractice.LeetCode_Classify.BFS;

public class Code_0507_130 {
    //开一个二维布尔数组，记录哪些区域被遍历过。
    //枚举所有边界上的'O'，从该位置做Flood Fill，即做深度优先遍历，只遍历是'O'的位置，并将所有遍历到的位置都标记成true。
    //将所有未遍历到的位置变成'X'。

    //这里因为使用了boolean数组来统计，所以一定要考虑是否被重复访问的问题！！
    // 也可以把里面遍历到d的'O'改写成'y'这些字母 然后判断是否等于y ！ 这样就不会乱，可以不用boolean数组
    int n,m;
    boolean[][] is_visited;
    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1){
            return;
        }
        n = board.length;
        m = board[0].length;
        is_visited = new boolean[n][m];
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                is_visited[i][j] = false;
            }
        }

        for (int i = 0;i < n;i++) {
            if (board[i][m-1] == 'O') {
                dfs(board,i,m-1);
            }
            if (board[i][0] == 'O'){
                dfs(board,i,0);
            }
        }
        for (int i = 0;i < m;i++) {
            if (board[0][i] == 'O') {
                dfs(board,0,i);
            }
            if (board[n - 1][i] == 'O'){
                dfs(board,n-1,i);
            }
        }
        for (int i = 0 ;i < n;i++){
            for (int j = 0;j < m;j++){
                if (!is_visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i,int j){
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !is_visited[i][j] && board[i][j] == 'O'){
            is_visited[i][j] = true;
            dfs(board,i-1,j);
            dfs(board,i+1,j);
            dfs(board,i,j-1);
            dfs(board,i,j+1);
        }
    }
}
