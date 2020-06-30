package RePractice.LeetCode_Classify.DP;

public class Code_0616_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //走到0，0位置 是有一种方案的！！
        dp[0][0] = 1;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (i > 0){
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0){
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
