package RePractice.Summary_0824.DFS;

public class Code_0901_827 {
    int res = 0;
    public int largestIsland(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1){
            return 0;
        }
        boolean hashZero = false;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 0){
                    hashZero = true;
                    grid[i][j] = 1;
                    res = Math.max(res, dfs(grid,i,j));
                    grid[i][j] = 0;
                }
            }
        }
        return hashZero ? res : grid.length * grid.length;
    }

    public int dfs(int[][] grid, int i ,int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 2;
            int temp = 0;
            temp += 1 + dfs(grid,i + 1,j) + dfs(grid,i - 1,j)+ dfs(grid,i,j + 1)
                    + dfs(grid,i,j - 1);

            grid[i][j] = 1;
            return temp;
        }
        return 0;
    }
}
