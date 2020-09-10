package RePractice.Summary_0824;

import sun.tools.jconsole.Worker;

import java.util.Scanner;

public class Code_0907_xiaomi2 {
    static int len = 0;
    static int n = 3;
    static int m = 4;
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        len = word.length();

        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean[][] visited = new boolean[n][m];
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (dfs(board,word,visited,i,j,0)){
                    System.out.println("true");
                }else {
                    System.out.println("false");
                }
            }
        }
        if (word.equals("")){
            System.out.println("true");
        }else if(isFind){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
    static boolean dfs(char[][] board ,String word ,boolean[][] visited,int i ,int j ,int index){
        if (i < 0 || i > n || j < 0 || j > m || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        if (index == len - 1){
            return true;
        }
        visited[i][j] = true;
        boolean success = dfs(board,word,visited,i + 1,j,index + 1) ||
                dfs(board,word,visited,i - 1,j,index + 1)||
                dfs(board,word,visited,i,j + 1,index + 1)||
                dfs(board,word,visited,i ,j - 1,index + 1);
        if (success == false){
            visited[i][j] = false;
            return false;
        }
        return true;


    }
}
