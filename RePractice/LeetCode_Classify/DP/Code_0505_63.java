package RePractice.LeetCode_Classify.DP;
//第三题
public class Code_0505_63 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;
            int[][] f = new int[n][m];
            //有可能出现特殊情况！！ [[1]] 此时输出的答案是0 而不是1 所以要判断一下第一个数 特殊情况！
            if (obstacleGrid[0][0] != 1){
                f[0][0] = 1;
            }

            for (int i = 0 ;i < n;i++){
                for (int j = 0;j < m;j++){
                    if (obstacleGrid[i][j] == 1){
                        continue;
                    }
                    if (i > 0)f[i][j] += f[i - 1][j];
                    if (j > 0) f[i][j] += f[i][j - 1];
                }
            }
            return f[n-1][m-1];
        }
}
