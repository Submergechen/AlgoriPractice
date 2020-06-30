package RePractice.LeetCode_Classify.DP;

public class Code_0616_813 {
    //记忆化！
    double[][] m;
    double[] sum;
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        m = new double[K+1][n+1];
        sum = new double[n+1];
        for (int i = 1;i <= n; i++){
            sum[i] = sum[i - 1] + A[i - 1];
        }
        return help(A,K,n);
    }

    public double help(int[] A ,int k ,int n){
        if (m[k][n] > 0){
            return m[k][n];
        }
        if (k == 1){
            return sum[n] / n;
        }
        for (int i = k - 1;i < n;i++){
            m[k][n] = Math.max(m[k][n],help(A,k - 1,i) + (sum[n] - sum[i] / (n - i)));
        }
        return m[k][n];
    }


    //dp
    //需要多看看！！
    public double largestSumOfAverages1(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[K+1][n+1];
        double[] sum = new double[n+1];
        for (int i = 1;i <= n; i++){
            sum[i] = sum[i - 1] + A[i - 1];
            dp[1][i] = sum[i] / i;
        }

        for (int k = 2; k <= K;k++ ){
            for (int i = k;i <= n;i++){
                for (int j = k - 1;j < i;j++){
                    dp[k][i] = Math.max(dp[k][i],dp[k - 1][j] + (sum[i] - sum[j]) / (i - j));
                }
            }
        }
        return dp[K][n];

    }
}
