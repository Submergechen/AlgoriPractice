package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_DFS_0725_37 {
    boolean[][] rows;
    boolean[][] cols;
    boolean[][][] cell;
    public void solveSudoku(char[][] board) {
        int n = board.length;
        rows = new boolean[n][9];
        cols = new boolean[n][9];
        cell = new boolean[n / 3][n / 3][9];

        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                if (board[i][j] != '.'){
                    int t = board[i][j] - '1';
                    rows[i][t] = cols[j][t] = cell[i / 3][j / 3][t] = true;
                }
            }
        }
        dfs(board,0,0);
    }

    public void dfs(char[][] board , int i , int j){
        if (j == 9){
            i++;
            j = 0;
        }
        if (i == 9){
            return;
        }
        if (board[i][j] != '.'){
            dfs(board,i,j+1);
            return;
        }
        for (int k = 0;k < 9;k++){
            if (!rows[i][k] && !cols[j][k] && !cell[i / 3][j / 3][k]){
                rows[i][k] = cols[j][k] = cell[i / 3 ][j / 3][k] = true;
                board[i][j] = (char) ('1' + k);
                dfs(board,i,j+1);
                rows[i][k] = cols[j][k] = cell[i / 3 ][j / 3][k] = false;
                board[i][j] = '.';

            }
        }

    }
}


    boolean[][] rows;
    boolean[][] cols;
    boolean[][][] cell;
    public void solveSudoku(char[][] board) {
        int n = board.length;
        rows = new boolean[n][9];
        cols = new boolean[n][9];
        cell = new boolean[n / 3][n / 3][9];

        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                if (board[i][j] != '.'){
                    int t = board[i][j] - '1';
                    rows[i][t] = cols[j][t] = cell[i / 3][j / 3][t] = true;
                }
            }
        }
        dfs(board,0,0);
    }

    public boolean dfs(char[][] board , int i , int j){
        if (j == 9){
            i++;
            j = 0;
        }
        if (i == 9){
            return true;
        }
        if (board[i][j] != '.'){

            return dfs(board,i,j+1);
        }
        for (int k = 0;k < 9;k++){
            if (!rows[i][k] && !cols[j][k] && !cell[i / 3][j / 3][k]){
                rows[i][k] = cols[j][k] = cell[i / 3 ][j / 3][k] = true;
                board[i][j] = (char) ('1' + k);
                if (dfs(board,i,j+1)){
                    return true;
                }
                rows[i][k] = cols[j][k] = cell[i / 3 ][j / 3][k] = false;
                board[i][j] = '.';

            }
        }
        return false;
    }