package RePractice.LeetCode_Classify.DP;

public class Code_0618_acwing282 {
    public int solution(int N , int[] nums){
        //前缀和
        //dp[i][j]

        int[] sum = new int[N + 1];
        int[][] dp = new int[N][N];
        //
        //sum[0] = nums[0];
        //前缀和的求法！
        for (int i = 1;i <= N;i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        //这里是从1开始计算的！！ 因为输入的时候也是从1开始计算  前缀和前缀和！
        for (int len = 2;len <= N;len++){
            //左端点
            for (int i = 1; i <= N - len + 1;i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i;k < j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k+1][j] + sum[j] - sum[i - 1]);
                }
            }
        }
        return dp[1][N];

    }
}
