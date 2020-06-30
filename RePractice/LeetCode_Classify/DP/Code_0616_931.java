package RePractice.LeetCode_Classify.DP;

import jdk.nashorn.internal.runtime.FindProperty;

public class Code_0616_931 {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0; j < n;j++){
                //这里 是因为i >= 1  之前写成了 i > 1 和 j < 1 ！
                dp[i][j] = A[i][j];
                int t = Integer.MAX_VALUE;
                if (i == 0 ){
                    t = 0;
                }
                if (i >= 1){
                    t = dp[i - 1][j];
                }
                if (i >= 1 && j >= 1){
                    t = Math.min(t ,dp[i - 1][j - 1]);
                }
                if (i >= 1 && j + 1 < n){
                    t = Math.min(t ,dp[i - 1][j + 1]);
                }
                dp[i][j] += t;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < n;i++){
            res = Math.min(res,dp[m - 1][i]);
        }
        return res;
    }

    public int minFallingPathSum1(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0;i < n;i++){
            dp[0][i] = A[0][i];
        }
        for (int i = 1;i < m;i++){
            for (int j = 0; j < n;j++){
                dp[i][j] = Math.min(Integer.MAX_VALUE,dp[i - 1][j]);

                if (j > 0){
                    dp[i][j] = Math.min(dp[i][j],dp[i - 1][j - 1]);
                }
                if (j < n - 1){
                    dp[i][j] = Math.min(dp[i][j],dp[i - 1][j + 1]);
                }
                dp[i][j] += A[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < n;i++){
            res = Math.min(res,dp[m - 1][i]);
        }
        return res;
    }
}

