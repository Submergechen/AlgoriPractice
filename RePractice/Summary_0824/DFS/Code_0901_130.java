package RePractice.Summary_0824.DFS;

public class Code_0901_130 {
    boolean[][] visited;
    int row;
    int col;
    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];

        for (int i = 0;i < row;i++){
            if (board[i][0] == 'O'){
                dfs(board,i,0 );
            }
            if (board[i][col - 1] == '0'){
                dfs(board,i, col - 1 );
            }
        }
        for (int j = 0;j < col;j++){
            if (board[0][j] == 'O'){
                dfs(board,0, j );
            }
            if (board[row - 1][j] == '0'){
                dfs(board,row - 1, j );
            }
        }

        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if (!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board ,int i ,int j){
        if (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j] && board[i][j] == 'O'){
            visited[i][j] = true;
            dfs(board,i + 1,j);
            dfs(board,i - 1,j);
            dfs(board,i ,j + 1);
            dfs(board,i,j - 1);
        }
    }
}
