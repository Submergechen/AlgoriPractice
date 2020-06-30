package RePractice.LeetCode_Classify.Dfs;

public class Code_0429_9_37 {
    //特别棒！！！
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0;i < 9; i++){
            for (int j = 0; j < 9; j++){
                char c = board[i][j];
                if (c != '.'){
                    int t = c - '1';
                    row[i][t] = col[j][t] = cell[i/3][j/3][t] = true;
                }
            }
        }
        dfs(board,0,0);
    }

    public boolean dfs(char[][] board , int x , int y){
        if (y == 9){
            x = x + 1;
            y = 0;
        }
        if (x == 9){
            return true;
        }
        if (board[x][y] != '.'){
            //少了return
            return dfs(board,x,y+1);
        }
        for (int i = 0; i < 9; i++){
            if (row[x][i] != true && col[y][i] != true &&cell[x/3][y/3][i] != true){
                board[x][y] = (char) (i +'1');
                row[x][i] = col[y][i] = cell[x/3][y/3][i] = true;
                //如果填了这个是正确的，那么可以返回true
                if (dfs(board,x,y+1)){
                    return true;
                }
                //还原
                board[x][y] = '.';
                row[x][i] = col[y][i] = cell[x/3][y/3][i] = false;

            }
        }
        return false;
    }
}
