package RePractice.Summary_0824;

public class Code_0902_shoppe1 {
    // 1 3 5 2
    public int getMinScore (int[] gz) {
        // w        int n = gz.length;
        int n = gz.length;
        int[][] dp = new int[n][n];

        for (int i = 0;i < n;i++){
            for (int j = 0;j < n && (i + j) < n;j++){
                dp[j][i + j] = Integer.MAX_VALUE;
                if (i == 0){
                    dp[j][i + j] = 0;
                }else {
                    for (int k = j;k < i + j;k++){
                        dp[j][i + j] = Math.min(dp[j][i + j],dp[j][k] + dp[k + 1][i + j] + helper(gz,j,i + j));
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
    public int helper(int[] gz,int l ,int r){
        int sum = 0;
        for (int i = l;i <= r;i++){
            sum += gz[i];
        }
        return sum;
    }
}
