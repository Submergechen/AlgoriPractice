package RePractice.Summary_0824.DFS;

public class Code_0901_200 {
    int res = 0;
    public int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1){
            return 0;
        }
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i ,int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid,i + 1,j);
            dfs(grid,i - 1,j);
            dfs(grid,i,j + 1);
            dfs(grid,i,j - 1);
        }
    }
}
