package RePractice.SwordOffer;

public class Code_1216_12hasPath {
    //回溯 一般用递归
    public static boolean hasPath(char[][] path , char[] str){
        if (path == null || path.length == 0 || path[0].length == 0){
            return false;
        }

        int row = path.length;
        int col = path[0].length;


        int stringLength = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0 ; i < row; i++){
            for (int j = 0; j < col ;j++){
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < row ; i++){
            for (int j = 0; j < col;j++){
                if (process(path,str,i,j,row,col,stringLength,visited)){
                    return true;
                }
            }
        }
        return false;


    }

    public static boolean process(char[][] path , char[] str ,int i ,int j, int row ,int col ,
                                  int length,boolean[][] visited){
        if (i < 0 || i >= row || j < 0|| j >= col
                ||visited[i][j] || str[length] != path[i][j] ){
            return false;
        }

        if (length == str.length - 1){
            return true;
        }

        //之前自己 这个visited[i][j]没有一开始就置true的话， 后面的preocess过程是有可能回到原点的，此时因为没有事先
        //置为true，就会错误！！
        visited[i][j] = true;
        boolean hasPath = false;
        hasPath = process(path,str,i + 1,j,row,col,length+1,visited) ||
                process(path,str,i - 1,j,row,col,length+1,visited)||
                process(path,str,i,j-1,row,col,length+1,visited)||
                process(path,str,i,j+1,row,col,length+1,visited);

        if (!hasPath){
            visited[i][j] = false;
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] A = new char[][]{{'A','B','T','G'},{'C','F','C','S'},{'J','D','E','H'}};
        char[] chars  = new char[]{'B','F','C','E'};
        boolean res = hasPath(A,chars);
        System.out.println(res);
    }
}
