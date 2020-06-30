package RePractice.SwordOffer0316Twice;

public class Code_0325_12hasPath {
    public boolean solution(char[][] arr , char[] chars){
        if (arr == null || arr.length < 1 || arr[0].length < 1){
            return false;
        }
        int rows = arr.length - 1;
        int cols = arr[0].length - 1;

        boolean[][] is_visited = new boolean[rows][cols];

        for (int i = 0; i <= rows; i++){
            for (int j = 0; j <= cols; j++){
                is_visited[i][j] = false;
            }
        }

        int index = 0;

        for (int i = 0;i <= rows; i++){
            for (int j = 0; j <= cols; j++){
                if (process(arr,is_visited,chars,i,rows,j,cols,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean process(char[][] arr , boolean[][] is_visited ,char[] chars ,
                        int i ,int rows, int j ,int cols , int index ){
        if (i > rows || j > cols || i < 0 || j > 0
                || !is_visited[i][j] || arr[i][j] != chars[index]){
            return false;
        }

        if (index == chars.length - 1){
            return true;
        }
        is_visited[i][j] = true;
        boolean has_path = false;
        //回溯法，有可能四个方向都不能走，所以要回溯！！
        has_path=  process(arr,is_visited,chars,i + 1,rows , j ,cols ,index + 1) ||
                process(arr,is_visited,chars,i ,rows , j + 1 ,cols ,index + 1) ||
                process(arr,is_visited,chars,i ,rows , j - 1,cols ,index + 1) ||
                process(arr,is_visited,chars,i - 1,rows , j ,cols ,index + 1);

        if (!has_path){
            is_visited[i][j] =false;
        }
        return has_path;

    }
}
