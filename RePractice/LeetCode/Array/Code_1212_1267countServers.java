package RePractice.LeetCode.Array;

//dfs 深度优先搜索    也可以数组计数
public class Code_1212_1267countServers {
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        //加上所有岛数量大于1 的数

        for (int i = 0;  i < row ; i++){
            for (int j = 0; j < col ; j++){
                if (grid[i][j] == 1 ){
                    int count = process(grid,i,j,row,col);
                    if (count > 1){
                        res += count;
                    }
                }
            }
        }

        return res;
    }

    public static int process(int[][] grid ,int i , int j ,int row ,int col ){
        if (i < 0 || i > row || j < 0 || j > col || grid[i][j] == 0){
            return 0;
        }
        int cur = 1;
        grid[i][j] = 0;
        for (int q = 0 ; q < row ; q ++){
            if (grid[q][j] == 1){
                cur += process(grid,q,j,row,col);
            }
        }

        for (int p = 0; p < col ;p++){
            if (grid[i][p] == 1){
                cur += process(grid,i,p,row,col);
            }
        }
        return cur;
    }
}
