package RePractice.NewPractice_7022;

public class Code_DFS_0725_36 {
    boolean[][] rows;
    boolean[][] cols;
    boolean[][][] cell;
    public boolean isValidSudoku(char[][] board) {


        rows = new boolean[9][9];
        cols = new boolean[9][9];
        cell = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    if (rows[i][t] || cols[j][t] || cell[i / 3][j / 3][t]) {
                        return false;
                    }
                    rows[i][t] = cols[j][t] = cell[i / 3][j / 3][t] = true;
                }

            }
        }
        return true;


    }
}


