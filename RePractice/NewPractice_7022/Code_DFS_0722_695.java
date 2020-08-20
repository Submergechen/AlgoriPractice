package RePractice.NewPractice_7022;

public class Code_DFS_0722_695 {
    //taicai!!
    int n;
    int m;
    boolean[][] is_visited;
    int max = 0;
    int res;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        is_visited = new boolean[n][m];
        for (int i = 0;i < n;i++ ){
            for (int j = 0;j < m;j++){
                if (grid[i][j] == 1) {
                    res = 0;
                    dfs(grid, i, j, is_visited);
                    max = Math.max(max, res);
                }
            }
        }
        return max;
    }


    public boolean dfs(int[][] grid ,int i ,int j ,boolean[][] is_visited){
        if (i < 0 || i >= n || j < 0 || j >= m || is_visited[i][j] || grid[i][j] == 0){
            return false;
        }
        is_visited[i][j] = true;
        res += 1;
        boolean successs = dfs(grid,i - 1,j,is_visited)
                ||dfs(grid,i - 1,j,is_visited)
                || dfs(grid,i - 1,j,is_visited)||dfs(grid,i - 1,j,is_visited);
        if (!successs){
            is_visited[i][j] = false;
        }
        return successs;
    }
}
