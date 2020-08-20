package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_DFS_0811_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] is_visited = new boolean[rows][cols];
        for(String word : words){

            for (int i = 0; i < rows;i ++){
                for (int j = 0; j < cols;j++){
                    is_visited[i][j] =false;
                }
            }
            if(helper(board,word,rows,cols,is_visited)){
                res.add(word);
            }

        }
        return res;
    }
    public boolean helper(char[][] board, String words,int rows,int cols,
                          boolean[][] is_visited){
        char[] chars = words.toCharArray();
        for(int i = 0; i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(dfs(board,chars,0,i,j,rows,cols,is_visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,char[] chars,int index ,
                       int i , int j ,int rows, int cols,
                       boolean[][] is_visited){
        if(i < 0 || i >= rows || j < 0 || j >= cols || is_visited[i][j]
                || board[i][j] != chars[index]){
            return false;
        }
        if(index == chars.length){
            return true;
        }
        is_visited[i][j] = true;

        boolean is_success ;
        is_success = dfs(board,chars,index + 1,i - 1, j , rows,cols,is_visited)
                ||dfs(board,chars,index + 1,i + 1, j , rows,cols,is_visited)
                ||dfs(board,chars,index + 1,i , j - 1 , rows,cols,is_visited)
                ||dfs(board,chars,index + 1,i, j + 1 , rows,cols,is_visited);
        if(is_success == false){
            is_visited[i][j] = false;
        }
        return is_success;
    }
}
