package RePractice.LeetCode_Classify.BFS;

public class Code_0507_200 {
    public int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1 || grid == null){
            return -1;
        }
        int n = grid.length , m = grid[0].length;
        int res = 0;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (grid[i][j] == 1){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid , int i ,int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid,i - 1,j);
            dfs(grid,i + 1,j);
            dfs(grid,i,j - 1);
            dfs(grid,i ,j + 1);
        }
    }
}
