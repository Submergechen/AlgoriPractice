package RePractice.LeetCode_Classify.DP;

public class Code_0616_64 {
    public int minPathSum(int[][] grid) {
        //为什么不能这么写呢？ padding的问题！！？？？
        //是因为 只能从左上走到右下！ 只能向下或者向右移动！！所以边界处是很特殊的！！！！！
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1;i <= m;i++){
            for (int j = 1;j <= n;j++){
                dp[i][j] = Math.min(dp[i - 1][j] ,dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
    //正常写！
    public int minPathSum1(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m ][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m;i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n;i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i - 1][j] ,dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1] ;
    }
}
