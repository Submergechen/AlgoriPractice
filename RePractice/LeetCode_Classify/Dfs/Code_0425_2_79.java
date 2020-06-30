package RePractice.LeetCode_Classify.Dfs;

import class_08.FaceBook;

public class Code_0425_2_79 {
    public boolean exist(char[][] board, String word) {
        if (board.length < 1 || board[0].length < 1 ){
            return false;
        }
        char[] chars = word.toCharArray();
        int index = 0;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] is_visited = new boolean[rows][cols];
        for (int i = 0;i < rows; i++){
            for (int j = 0; j < cols;j++){
                is_visited[i][j] = false;
            }
        }

        for (int i = 0; i < rows;i++){
            for (int j = 0;j < cols; j++){
                if (dfs(board,chars, i, j ,is_visited,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board , char[] chars ,int i , int j, boolean[][] is_visited , int index){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||chars[index] !=board[i][j]
                || is_visited[i][j] == true){
            return false;
        }
        if (index == chars.length - 1){
            return true;
        }
        is_visited[i][j] = true;
        boolean is_success =  dfs(board,chars,i,j+1,is_visited,index + 1)||dfs(board,chars,i,j-1,is_visited,index + 1)||
                dfs(board,chars,i + 1,j,is_visited,index + 1)
                || dfs(board,chars,i - 1,j ,is_visited,index + 1);
        if (is_success){
            return true;
        }else {
            is_visited[i][j] = false;
            return false;
        }

    }
}
