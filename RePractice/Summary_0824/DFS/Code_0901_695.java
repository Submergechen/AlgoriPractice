package RePractice.Summary_0824.DFS;

public class Code_0901_695 {
    int res = 0;
    int row;
    int col;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                res = Math.max(dfs(grid,i,j, 0),res);
            }
        }
        return res;
    }

    public int dfs(int[][] grid,int i , int j , int cur){
        if (i < 0 || i > row || j < 0 || j > col || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        cur += 1;
        cur += dfs(grid,i + 1, j,cur) + dfs(grid,i - 1, j,cur) + dfs(grid,i, j - 1,cur)
                +dfs(grid,i, j + 1 , cur);
        return cur;
    }
}
